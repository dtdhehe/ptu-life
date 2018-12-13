package com.dtdhehe.ptulife.service;

import com.dtdhehe.ptulife.entity.PtuNews;

import java.util.List;

/**
 * 新闻service
 *
 * author:dtdhehe
 * date:2018-12-12
 */
public interface NewsService {

    /**
     * 查询所有新闻
     * @return
     */
    List<PtuNews> queryAllNews();

    /**
     * 根据主键查找单个新闻
     * @param newsId
     * @return
     */
    PtuNews queryNewsById(String newsId);

    /**
     * 保存新闻
     * @param ptuNews
     * @return
     */
    PtuNews save(PtuNews ptuNews);
}
