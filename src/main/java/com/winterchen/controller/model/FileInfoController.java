package com.winterchen.controller.model;

import com.winterchen.api.QCloudService;
import com.winterchen.constant.ErrorsWepm;
import com.winterchen.dto.SessionUser;
import com.winterchen.dto.UserOnlineBo;
import com.winterchen.exception.BusinessException;
import com.winterchen.model.FileInfoDomain;
import com.winterchen.model.UserDomain;
import com.winterchen.service.file.FileInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Donghua.Chen on 2018/3/25.
 */
@Api(value = "文件上传、下载API")
@RestController
public class FileInfoController {

    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    private QCloudService qCloudService;


    @ApiOperation("文件上传至腾讯云")
    @PostMapping("/uploadfile")
    public void fileUpLoadToQiNiuCloud(HttpServletRequest request,
                           HttpServletResponse response,
                                   MultipartFile file){
        //文件上传
        try {
            request.setCharacterEncoding( "utf-8" );
            response.setHeader( "Content-Type" , "text/html" );

            String fileUrl = qCloudService.fileUpLoad(file);
            UserDomain user =   (UserDomain) SecurityUtils.getSubject().getPrincipal();
            FileInfoDomain domain = new FileInfoDomain();
            domain.setCreater(user.getNickname());
            domain.setFileFrom("QCloud");
            domain.setFileName(file.getOriginalFilename());
            domain.setFileSize(file.getSize());
            domain.setUrl(fileUrl);
            domain.setFileType(file.getContentType());
            domain.setState(1);
            domain.setWhoUse("blog");
            fileInfoService.addFileInfo(domain);
            response.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"" + fileUrl + "\"}" );

        } catch (IOException e) {
            e.printStackTrace();
            try {
                response.getWriter().write( "{\"success\":0}" );
            } catch (IOException e1) {
                throw BusinessException.withErrorCode(ErrorsWepm.File.UPLOAD_FAIL)
                        .withErrorMessageArguments(e.getMessage());
            }
            throw BusinessException.withErrorCode(ErrorsWepm.File.UPLOAD_FAIL)
                    .withErrorMessageArguments(e.getMessage());
        }
    }

}
