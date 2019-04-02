package com.dtdhehe.ptulife.service;

import com.dtdhehe.ptulife.entity.Comment;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Create By Xie_东
 * on 2019/2/12 11:18
 * @author dtdhehe
 */
public interface CommentService {

    /**
     *添加一条评论
     */
    Comment add(Comment comment);

    /**
     * 删除一条评论
     */
    Integer del(Comment comment);

    /**
     * 根据业务id查询所有一级评论
     * @param postId
     * @param sort
     * @return
     */
    List<Comment> queryByPidIsNull(String postId, Sort sort);

    /**
     * 根据业务id查询所有二级评论
     * @param id
     * @param sort
     * @return
     */
    List<Comment> queryByPidAndPidIsNotNull(String id, Sort sort);

    /**
     * 根据业务id全部评论计算热度
     * @param pid
     * @return
     */
    Integer getHotByComment(String pid);

}
