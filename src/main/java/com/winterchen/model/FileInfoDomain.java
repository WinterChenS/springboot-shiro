package com.winterchen.model;

import java.util.Date;

/**
 * 文件实体类
 * Created by Donghua.Chen on 2018/3/25.
 */
public class FileInfoDomain {
    /** 主键 */
    private Integer id;
    /** 文件名 */
    private String fileName;
    /** 文件标题 */
    private String fileTitle;
    /** 文件路径 */
    private String url;
    /** 文件类型 */
    private String fileType;
    /** 文件大小 */
    private Long fileSize;
    /** 文件存储提供商 */
    private String fileFrom;
    /** 文件用途 */
    private String whoUse;
    /** 标签 */
    private String tags;
    /** 状态 0 禁用 1 正常 */
    private Integer state;
    /** 其他 */
    private String description;
    /** 创建人 */
    private String creater;
    /** 创建时间 */
    private Date createTime;
    /** 最后修改人 */
    private String modifyer;
    /** 最后修改时间 */
    private Date modifyTime;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyer() {
        return modifyer;
    }

    public void setModifyer(String modifyer) {
        this.modifyer = modifyer;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
