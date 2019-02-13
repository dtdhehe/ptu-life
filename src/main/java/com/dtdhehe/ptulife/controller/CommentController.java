package com.dtdhehe.ptulife.controller;

import com.alibaba.fastjson.JSONObject;
import com.dtdhehe.ptulife.entity.Comment;
import com.dtdhehe.ptulife.service.CommentService;
import com.dtdhehe.ptulife.util.DateUtils;
import com.dtdhehe.ptulife.util.KeyUtils;
import com.dtdhehe.ptulife.vo.CommentVO;
import com.dtdhehe.ptulife.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Create By Xie_东
 * on 2019/2/12 11:28
 * @author dtdhehe
 */
@RestController
@RequestMapping("/comment/commentController")
public class CommentController {

    private final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    /**
     * 添加评论
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResultVO add(@RequestParam(name = "comment",required = false)String commentObject){
        JSONObject jsonObject = JSONObject.parseObject(commentObject);
        logger.info("开始添加评论");
        ResultVO resultVO = new ResultVO();
        Comment comment = new Comment();
        comment.setId(KeyUtils.getUniqueKey());
        comment.setContent((String) jsonObject.get("content"));
        comment.setCreateTime(DateUtils.getCurrentDateTime());
        comment.setPid((String) jsonObject.get("pid"));
        comment.setPostId((String) jsonObject.get("postId"));
        comment.setReplyUserId((String) jsonObject.get("replyUserId"));
        comment.setUserId((String) jsonObject.get("userId"));
        try {
            Comment commentNew = commentService.add(comment);
            if (commentNew != null){
                resultVO.setStatus("0");
                resultVO.setObject(comment);
            }else {
                logger.error("评论新增失败");
                resultVO.setStatus("1");
                //添加评论  8575
                resultVO.setError_code("8575");
                resultVO.setError_msg("commentNew对象为空");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            resultVO.setStatus("1");
            //添加评论  8575
            resultVO.setError_code("8575");
            resultVO.setError_msg(e.getMessage());
        }

        return resultVO;
    }

    /**
     * 添加评论
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public ResultVO query(@RequestParam("postId")String postId){
        logger.info("根据业务id查询评论");
        Sort sort = new Sort(Sort.Direction.ASC,"createTime");
        List<Comment> commentList = commentService.queryByPidIsNull(postId,sort);
        //把时间转换成页面显示格式
        Iterator it = commentList.iterator();
        List<CommentVO> resultList = new ArrayList<>();
        while (it.hasNext()){
            Comment comment = (Comment) it.next();
            comment.setCreateTime(DateUtils.date2ViewType(comment.getCreateTime()));
            List<Comment> childCommentList = commentService.queryByPidAndPidIsNotNull(comment.getId(),sort);
            if (childCommentList.size() != 0){
                Iterator<Comment> itChild = childCommentList.iterator();
                while (itChild.hasNext()){
                    Comment commentChild = itChild.next();
                    commentChild.setCreateTime(DateUtils.date2ViewType(commentChild.getCreateTime()));
                }
            }
            CommentVO commentVO = new CommentVO();
            BeanUtils.copyProperties(comment,commentVO);
            commentVO.setCommentList(childCommentList);
            resultList.add(commentVO);
        }
        ResultVO resultVO = new ResultVO();
        resultVO.setStatus("0");
        resultVO.setObject(resultList);
        return resultVO;
    }

}
