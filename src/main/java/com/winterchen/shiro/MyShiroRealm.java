package com.winterchen.shiro;

import com.winterchen.model.RoleDomain;
import com.winterchen.model.UserDomain;
import com.winterchen.model.UserPermissionDomain;
import com.winterchen.service.role.RoleService;
import com.winterchen.service.user.UserService;
import com.winterchen.service.userpermission.UserPermissionService;
import com.winterchen.util.MyDES;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * shiro身份校验核心类
 *
 * @author 作者: winterchen
 * @date 创建时间：2018年02月22日13:57:24
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserPermissionService permissionService;

    //用户登录次数计数  redisKey 前缀

    private String SHIRO_LOGIN_COUNT = "shiro_login_count_";

    //用户登录是否被锁定    一小时 redisKey 前缀

    private String SHIRO_IS_LOCK = "shiro_is_lock_";

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("权限认证方法：MyShiroRealm.doGetAuthorizationInfo()");
        UserDomain user = (UserDomain) SecurityUtils.getSubject().getPrincipal();
        String userId = user.getId().toString();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("user_id", userId);

		List<RoleDomain> roleList = roleService.selectByMap(map);

		Set<String> roleSet = new HashSet<String>();

		for(RoleDomain role : roleList){

			roleSet.add(role.getType());

		}
        info.setRoles(roleSet);
        //根据用户ID查询权限（permission），放入到Authorization里。
		List<UserPermissionDomain> permissionList = permissionService.selectByMap(map);

		Set<String> permissionSet = new HashSet<String>();

		for(UserPermissionDomain Permission : permissionList){

			permissionSet.add(Permission.getName());

		}

        info.setStringPermissions(permissionSet);
        return info;
    }


    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String name = token.getUsername();
        String password = String.valueOf(token.getPassword());
        //访问一次，计数一次
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.increment(SHIRO_LOGIN_COUNT+name, 1);
        //当访问次数超过5次被锁定一小时
        if (Integer.parseInt(opsForValue.get(SHIRO_LOGIN_COUNT+name)) > 5){
            opsForValue.set(SHIRO_IS_LOCK + name, "LOCK");
            //设置缓存的超时时间
            stringRedisTemplate.expire(SHIRO_IS_LOCK+name, 1, TimeUnit.HOURS);
        }
        if ("LOCK".equals(opsForValue.get(SHIRO_IS_LOCK + name))){
            throw new DisabledAccountException("由于密码输入错误次数大于5次，帐号已经禁止登录！");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("nickname", name);
        //密码进行加密处理  明文为  password+name

        String paw = password+name;
        String pawDES = MyDES.encryptBasedDes(paw);
        map.put("pswd", pawDES);
        UserDomain user = null;

        user = userService.selectUserByMap(map);

        if (null == user){
            throw new AccountException("帐号或密码不正确！");
        }else if ("0".equals(user.getStatus())){
            /**

             * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>

             */
            throw new DisabledAccountException("此帐号已经设置为禁止登录！");
        }else {
            //登录成功

            //更新登录时间 last login time

            user.setLastLoginTime(new Date());
            userService.updateById(user);
            //清空登录计数
            opsForValue.set(SHIRO_LOGIN_COUNT+name, "0");
        }

        Logger.getLogger(getClass()).info("身份认证成功，登录用户："+name);
        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
