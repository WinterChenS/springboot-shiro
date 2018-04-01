package com.winterchen.service.file;

import com.winterchen.dto.FileInfoDto;
import com.winterchen.dto.cond.FileInfoCond;
import com.winterchen.model.FileInfoDomain;

import java.util.List;

/**
 * Created by Donghua.Chen on 2018/3/25.
 */
public interface FileInfoService {

    /**
     * @Author: Donghua.Chen
     * @Description: 添加文件信息
     * @Date: 2018/3/25
     * @param fileInfo
     */
    void addFileInfo(FileInfoDomain fileInfo);

    /**
     * @Author: Donghua.Chen
     * @Description: 删除文件信息
     * @Date: 2018/3/25
     * @param fileId 文件主键编号
     */
    void deleteFileInfo(Integer fileId);

    /**
     * @Author: Donghua.Chen
     * @Description: 修改文件信息
     * @Date: 2018/3/25
     * @param fileInfo 文件信息
     */
    void updateFileInfo(FileInfoDomain fileInfo);
    
    /**
     * @Author: Donghua.Chen
     * @Description: 根据条件获取文件信息
     * @Date: 2018/3/25
     * @param cond 查询条件
     * @param pageNum 开始页数
     * @param pageSize 每页显示数量
     */
    List<FileInfoDto> getFileInfos(FileInfoCond cond, int pageNum, int pageSize);
}
