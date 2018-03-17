package com.winterchen.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

/**
 * Created by Donghua.Chen on 2018/3/8.
 */
public class ErrorTable {

    private static final Logger logger = LoggerFactory.getLogger(ErrorTable.class);
    private static final PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
    private static Properties DEFAULT_ERROR_MESSAGES = new Properties();
    private static Locale DEFAULT_LOCALE;
    private static final Map<Locale, Properties> localeMessagesMap;
    private static String i18nBaseNames;
    private static boolean initialized;

    public ErrorTable() {
    }

    public static synchronized void init(String i18nBaseNames, String defaultLocaleName) throws IOException {
        i18nBaseNames = i18nBaseNames;
        if(StringUtils.hasText(defaultLocaleName)) {
            DEFAULT_LOCALE = new Locale(defaultLocaleName);
        }

        initialized = true;
        init(DEFAULT_LOCALE);
    }

    private static synchronized void init(Locale locale) throws IOException {
        if(initialized) {
            Properties localeMessages = new Properties();
            localeMessagesMap.put(locale, localeMessages);
            String[] resourceNames = i18nBaseNames.split(",");
            String[] var3 = resourceNames;
            int var4 = resourceNames.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String resourceName = var3[var5];
                Resource[] resources = resourcePatternResolver.getResources(resourceName + "*_" + toStandardLocaleString(locale) + ".properties");
                Properties properties = new Properties();
                Resource[] var9 = resources;
                int var10 = resources.length;

                for(int var11 = 0; var11 < var10; ++var11) {
                    Resource resource = var9[var11];
                    URL path = resource.getURL();
                    String resourcePath;
                    if(path == null) {
                        resourcePath = resource.getFilename();
                    } else {
                        resourcePath = path.getPath();
                    }

                    logger.info("Loading APIResponse i18n source(ONLY support 'UTF-8' file encoding) => " + resourcePath);
                    Object reader = null;

                    try {
                        properties.load(new InputStreamReader(resource.getInputStream(), "utf-8"));
                        Set<String> keys = properties.stringPropertyNames();

                        String key;
                        for(Iterator var17 = keys.iterator(); var17.hasNext(); localeMessages.setProperty(key, properties.getProperty(key))) {
                            key = (String)var17.next();
                            if(localeMessages.containsKey(key)) {
                                logger.warn("duplicated APIResponse message key => " + key);
                            }
                        }
                    } catch (IOException var26) {
                        throw var26;
                    } finally {
                        if(reader != null) {
                            try {
                                ((InputStreamReader)reader).close();
                            } catch (Exception var25) {
                                ;
                            }
                        }

                    }
                }
            }

        }
    }

    private static String toStandardLocaleString(Locale locale) {
        return locale.toString();
    }

    public static String convertCode2LocaleMessage(String strCode) {
        Locale locale = LocaleContextHolder.getLocale();
        if(locale == null) {
            locale = DEFAULT_LOCALE;
        }

        return convertCode2LocaleMessage(strCode, locale);
    }

    private static String convertCode2LocaleMessage(Properties localMessages, String strCode) {
        String message = localMessages != null?localMessages.getProperty(strCode):null;
        if(message == null) {
            message = DEFAULT_ERROR_MESSAGES.getProperty(strCode);
        }

        if(!StringUtils.hasText(message)) {
            message = strCode;
        }

        return message;
    }

    public static String convertCode2LocaleMessage(String strCode, Locale locale) {
        Properties localeMessages = (Properties)localeMessagesMap.get(locale);
        if(localeMessages == null) {
            try {
                init(locale);
                localeMessages = (Properties)localeMessagesMap.get(locale);
            } catch (Exception var4) {
                logger.error(var4.getMessage(), var4);
            }
        }

        return convertCode2LocaleMessage(localeMessages, strCode);
    }

    public static Properties getErrors() {
        Locale locale = LocaleContextHolder.getLocale();
        if(locale == null) {
            locale = DEFAULT_LOCALE;
        }

        Properties defaultLocaleMessages = (Properties)localeMessagesMap.get(locale);
        if(defaultLocaleMessages == null) {
            defaultLocaleMessages = new Properties();
        }

        Properties ret = (Properties)defaultLocaleMessages.clone();
        return mergeProperties(ret, DEFAULT_ERROR_MESSAGES);
    }

    private static Properties mergeProperties(Properties src, Properties overwrite) {
        Properties ret = new Properties();
        Enumeration keyEnum;
        String key;
        if(src != null) {
            keyEnum = src.keys();

            while(keyEnum.hasMoreElements()) {
                key = keyEnum.nextElement().toString();
                ret.put(key, src.getProperty(key));
            }
        }

        if(overwrite != null) {
            keyEnum = overwrite.keys();

            while(keyEnum.hasMoreElements()) {
                key = keyEnum.nextElement().toString();
                if(!ret.containsKey(key)) {
                    ret.put(key, overwrite.getProperty(key));
                }
            }
        }

        return ret;
    }

    static {
        DEFAULT_LOCALE = Locale.SIMPLIFIED_CHINESE;
        localeMessagesMap = new HashMap();
        initialized = false;
        DEFAULT_ERROR_MESSAGES.setProperty("success", "API调用成功");
        DEFAULT_ERROR_MESSAGES.setProperty("fail", "API调用失败");
        DEFAULT_ERROR_MESSAGES.setProperty("unauthorized-invoker", "拒绝访问, 未授权的服务调用者");
        DEFAULT_ERROR_MESSAGES.setProperty("validation-fail", "请求参数验证失败");
        DEFAULT_ERROR_MESSAGES.setProperty("bad-parameter", "拒绝访问, 请求参数错误");
        DEFAULT_ERROR_MESSAGES.setProperty("unauthorized", "拒绝访问, 您没有权限请求该资源");
        DEFAULT_ERROR_MESSAGES.setProperty("not-initialized", "返回值未初始化");
        DEFAULT_ERROR_MESSAGES.setProperty("user-not-login", "用户未登录");
        DEFAULT_ERROR_MESSAGES.setProperty("rpc-fail", "远程调用失败【{0}】");
    }
}
