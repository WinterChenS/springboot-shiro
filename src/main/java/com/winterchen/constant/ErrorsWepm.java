package com.winterchen.constant;

/**
 * 异常信息
 * Created by Donghua.Chen on 2018/3/8.
 */
public interface ErrorsWepm {


        // 公用错误定义
        interface Common {
            // 无效的参数
            String INVALID_PARAM = "com.winterchen.app.InvalidParam";
            // 无权限做此操作
            String NO_AUTH_OPERATE = "com.winterchen.app.no.auth.operate";
            // 无法找到对应的数据以继续执行
            String CANNOT_FOUND_DATA_TO_CONTINUE = "com.winterchen.app.cannot.found.data.to.continue";
            // 发送邮件出错
            String SEND_MAIL_ERROR = "com.winterchen.app.send.mail.error";
        }

        // 权限验证
        interface Auth {
            // 验证用户密码出错
            String VALIDATE_USER_PASSWORD_ERROR = "com.winterchen.app.validate.user.password.error";
            // 用户名或密码错误
            String ACCOUNT_OR_PASSWORD_ERROR = "com.winterchen.app.account.or.password.error";
            // 用户名或密码错误并上锁
            String ACCOUNT_OR_PASSWORD_ERROR_AND_LOCK = "com.winterchen.app.account.or.password.error.and.lock";
            // 用户状态无效
            String ACCOUNT_STATUS_DISABLE = "com.winterchen.app.account.status.disable";
        }

        // 文件操作错误定义
        interface File {
            // 文件操作——无效的参数
            String INVALID_PARAM = "com.winterchen.app.file.invalid.param";
            // 文件上传——文件为空
            String UPLOAD_EMPTY = "com.winterchen.app.file.upload.empty";
            // 文件上传——失败
            String UPLOAD_FAIL = "com.winterchen.app.file.upload.fail";
            // 获取文件流出错
            String GET_INPUTSTREAM_ERROR = "com.winterchen.app.get.inputstream.error";
            // 读取Excel文件出错
            String READ_EXCEL_ERROR = "com.winterchen.app.read.excel.error";
            // 读取Excel导入数据为空
            String READ_EXCEL_DATA_EMPTY = "com.winterchen.app.read.excel.data.empty";
            // 读取MPP文件出错
            String READ_MPP_ERROR = "com.winterchen.app.read.mpp.error";
            // 读取MPP文件导入数据为空
            String READ_MPP_DATA_EMPTY = "com.winterchen.app.read.mpp.data.empty";
            // 写入MPP文件错误
            String WRITE_MPP_XML_ERROR = "com.winterchen.app.write.mpp.error";


        }

        // Date
        interface Date {
            // 日期操作
            String PARSE_ERROR = "com.winterchen.app.date.parse.error";
        }

        interface User {
            // 创建用户——系统已存在该用户
            String CREATE_USER_ALREADY_EXISTS = "com.winterchen.app.create.user.already.exists";
            // 创建用户——Jira用户没有对应账户
            String CREATE_USER_JIRA_NON_EXISTENT = "com.winterchen.app.create.user.jira.non.existent";
            // 设置用户密码出错
            String SET_USER_PASSWORD_ERROR = "com.winterchen.app.set.user.password.error";
            // 用户不存在
            String NON_EXIST = "com.winterchen.app.create.user.non-existent";
        }

}
