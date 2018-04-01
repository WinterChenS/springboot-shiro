package com.winterchen.service.file.impl;

import com.github.pagehelper.PageHelper;
import com.winterchen.dao.FileInfoDao;
import com.winterchen.dto.FileInfoDto;
import com.winterchen.dto.cond.FileInfoCond;
import com.winterchen.model.FileInfoDomain;
import com.winterchen.service.file.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 文件服务层
 * Created by Donghua.Chen on 2018/3/25.
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    private FileInfoDao fileInfoDao;

    /** 文件状态 - 禁用 */
    private static final Integer FILE_STATE_BAN = 0;

    /** 文件状态 - 正常 */
    private static final Integer FILE_STATE_OK = 1;

    private static Map<Integer, String> FILE_STATE_MAP = new ConcurrentHashMap<>();

    static{
        FILE_STATE_MAP.put(FILE_STATE_BAN, "禁用");
        FILE_STATE_MAP.put(FILE_STATE_OK, "正常");
    }


    @Override
    public void addFileInfo(FileInfoDomain fileInfo) {
        fileInfoDao.addFileInfo(fileInfo);
    }

    @Override
    public void deleteFileInfo(Integer fileId) {
        fileInfoDao.deleteFileInfo(fileId);
    }

    @Override
    public void updateFileInfo(FileInfoDomain fileInfo) {
        fileInfoDao.updateFileInfo(fileInfo);
    }

    @Override
    public List<FileInfoDto> getFileInfos(FileInfoCond cond, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return parseFileInfoDomainsToFileInfoDtos(fileInfoDao.getFileInfos(cond));
    }


    /**-------------转dto--------------*/

    private List<FileInfoDto> parseFileInfoDomainsToFileInfoDtos(List<FileInfoDomain> domains){
        List<FileInfoDto> rs = new LinkedList<>();
        for (int i = 0; i < domains.size(); i++) {
            FileInfoDto dto = parseFileInfoDomainToFileInfoDto(domains.get(i));
            rs.add(dto);
        }
        return rs;
    }

    private FileInfoDto parseFileInfoDomainToFileInfoDto(FileInfoDomain domain){
        FileInfoDto rs = rs = new FileInfoDto();
        rs.setId(domain.getId());
        rs.setFileName(domain.getFileName());
        rs.setFileTitle(domain.getFileTitle());
        rs.setUrl(domain.getUrl());
        rs.setFileType(domain.getFileType());
        rs.setFileSize(domain.getFileSize());
        rs.setFileFrom(domain.getFileFrom());
        rs.setWhoUse(domain.getWhoUse());
        rs.setTags(domain.getTags());
        rs.setState(domain.getState());
        rs.setStateName(FILE_STATE_MAP.get(domain.getState() == null ? 1 : domain.getState()));
        return rs;
    }
}
