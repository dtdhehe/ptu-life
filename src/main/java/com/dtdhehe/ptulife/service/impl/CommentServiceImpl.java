package com.dtdhehe.ptulife.service.impl;

import com.dtdhehe.ptulife.entity.Comment;
import com.dtdhehe.ptulife.repository.CommentRepository;
import com.dtdhehe.ptulife.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create By Xie_东
 * on 2019/2/12 11:21
 * @author dtdhehe
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment add(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Integer del(Comment comment) {
        Integer result = 0;
        try {
            commentRepository.delete(comment);
            result = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Comment> queryByPidIsNull(String postId, Sort sort) {
        return commentRepository.queryByPostIdAndPidIsNull(postId,sort);
    }

    @Override
    public List<Comment> queryByPidAndPidIsNotNull(String id, Sort sort) {
        return commentRepository.queryByPidAndPidIsNotNull(id,sort);
    }
}
