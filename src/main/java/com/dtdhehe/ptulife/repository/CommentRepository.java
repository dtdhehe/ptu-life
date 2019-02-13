package com.dtdhehe.ptulife.repository;

import com.dtdhehe.ptulife.entity.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create By Xie_东
 * on 2019/2/12 11:16
 * @author dtdhehe
 */
public interface CommentRepository extends JpaRepository<Comment,String> {

    /**
     * 根据业务id查询全部一级评论
     * @param postId
     * @param sort
     * @return
     */
    List<Comment> queryByPostIdAndPidIsNull(String postId, Sort sort);

    /**
     * 根据主评论的id查询全部二级评论
     * @param id
     * @param sort
     * @return
     */
    List<Comment> queryByPidAndPidIsNotNull(String id, Sort sort);
}
