package com.winterchen.service.sysuser;

import com.github.pagehelper.Page;
import com.winterchen.dto.UserOnlineBo;
import com.winterchen.util.FrontPage;

/**
 * 系统用户服务
 * Created by Donghua.Chen on 2018/3/5.
 */
public interface SysUserService {

    /**
     * 获取在线用户列表
     * @param frontPage
     * @return
     */
    Page<UserOnlineBo> getPagePlus(FrontPage<UserOnlineBo> frontPage);
}
