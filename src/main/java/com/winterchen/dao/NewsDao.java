package com.winterchen.dao;

import com.winterchen.model.NewsDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Donghua.Chen on 2018/3/20.
 */
@Mapper
public interface NewsDao {

    void batchAddNews(List<NewsDomain> newsDomains);

    void deleteNews(@Param("id") Integer id, @Param("startTime")Date startTime, @Param("endTime")Date endTime);

    List<NewsDomain> getNews();

    NewsDomain getNewById(@Param("id") Integer id);
}
