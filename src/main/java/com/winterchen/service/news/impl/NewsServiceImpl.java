package com.winterchen.service.news.impl;

import com.winterchen.dao.NewsDao;
import com.winterchen.model.NewsDomain;
import com.winterchen.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Donghua.Chen on 2018/3/20.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public void batchAddNews(List<NewsDomain> newsDomains) {
        newsDao.batchAddNews(newsDomains);
    }

    @Override
    public void deleteNews(Integer id, Date startTime, Date endTime) {
        newsDao.deleteNews(id, startTime, endTime);
    }

    @Override
    public List<NewsDomain> getNews(int pageNum, int pageSize) {
        return newsDao.getNews();
    }

    @Override
    public NewsDomain getNewById(Integer id) {
        return newsDao.getNewById(id);
    }
}
