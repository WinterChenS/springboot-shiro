package com.winterchen.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Donghua.Chen on 2018/3/26.
 */
public class StringUtil {

    /**
     * 文件上传，为文件重新命名
     **/
    public static String getFileRename(String name) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String sdfDate = sdf.format(date);
        int pos = name.lastIndexOf(".");
        String suffix = name.substring(pos);
        String rename = sdfDate+suffix;
        return rename;
    }
}
