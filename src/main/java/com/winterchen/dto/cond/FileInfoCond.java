package com.winterchen.dto.cond;

import java.util.Date;

/**
 * 文件查找参数
 * Created by Donghua.Chen on 2018/3/25.
 */
public class FileInfoCond {
    /** 主键 */
    private Integer id;
    /** 文件名 */
    private String fileName;
    /** 文件标题 */
    private String fileTitle;
    /** 文件类型 */
    private String fileType;
    /** 文件大小 */
    private Long minfileSize;

    private Long maxFileSize;
    /** 文件存储提供商 */
    private String fileFrom;
    /** 文件用途 */
    private String whoUse;
    /** 标签 */
    private String tags;
    /** 状态 0 禁用 1 正常 */
    private Integer state;
    /** 创建时间 */
    private Date startTime;

    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getMinfileSize() {
        return minfileSize;
    }

    public void setMinfileSize(Long minfileSize) {
        this.minfileSize = minfileSize;
    }

    public Long getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(Long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getFileFrom() {
        return fileFrom;
    }

    public void setFileFrom(String fileFrom) {
        this.fileFrom = fileFrom;
    }

    public String getWhoUse() {
        return whoUse;
    }

    public void setWhoUse(String whoUse) {
        this.whoUse = whoUse;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
