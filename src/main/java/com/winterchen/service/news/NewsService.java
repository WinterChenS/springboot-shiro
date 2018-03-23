package com.winterchen.service.news;

import com.winterchen.model.NewsDomain;

import java.util.Date;
import java.util.List;

/**
 * Created by Donghua.Chen on 2018/3/20.
 */
public interface NewsService {

    void batchAddNews(List<NewsDomain> newsDomains);

    void deleteNews(Integer id, Date startTime, Date endTime);

    List<NewsDomain> getNews(int pageNum, int pageSize);

    NewsDomain getNewById(Integer id);
}
