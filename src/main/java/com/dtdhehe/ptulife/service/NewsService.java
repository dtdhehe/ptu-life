package com.dtdhehe.ptulife.service;

import com.dtdhehe.ptulife.entity.PtuNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

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
     * 查询所有新闻
     * @return
     */
    Page<Map<String,Object>> findAllWithHead(Pageable pageable);

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

    /**
     * 根据用户id查询该用户全部新闻
     * @param userId
     * @return
     */
    Page<PtuNews> queryNewsByUserId(String userId,String newsTitle,Pageable pageable);

    /**
     * 根据新闻id删除该新闻
     * @param newsId
     */
    void delNewsById(String newsId);

}
