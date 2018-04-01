package com.winterchen.dao;

import com.winterchen.dto.cond.FileInfoCond;
import com.winterchen.model.FileInfoDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 文件持久层
 * Created by Donghua.Chen on 2018/3/25.
 */
@Mapper
public interface FileInfoDao {

    /**
     * @Author: Donghua.Chen
     * @Description: 添加文件信息
     * @Date: 2018/3/25
     * @param fileInfo
     */
    void addFileInfo(FileInfoDomain fileInfo);

    /**
     * @Author: Donghua.Chen
     * @Description: 删除文件
     * @Date: 2018/3/25
     * @param fileId 文件主键
     */
    void deleteFileInfo(Integer fileId);

    /**
     * @Author: Donghua.Chen
     * @Description: 更新文件信息
     * @Date: 2018/3/25
     * @param fileInfo
     */
    void updateFileInfo(FileInfoDomain fileInfo);

    /**
     * @Author: Donghua.Chen
     * @Description: 根据条件查找文件
     * @Date: 2018/3/25
     * @param cond 条件
     */
    List<FileInfoDomain> getFileInfos(FileInfoCond cond);
}
