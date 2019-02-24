package com.dtdhehe.ptulife.repository;

import com.dtdhehe.ptulife.entity.PtuNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 新闻dao
 * date:2018-12-12
 * @author dtdhehe
 */
public interface PtuNewsRepository extends JpaRepository<PtuNews,String> {

    /**
     * 根据用户id查询该用户全部新闻
     * @param userId
     * @param newsTitle
     * @param pageable
     * @return
     */
    @Query(value = "select t from PtuNews t where t.userId=?1 and t.newsTitle like %?2%")
    Page<PtuNews> findByUserId(String userId,String newsTitle, Pageable pageable);

}
