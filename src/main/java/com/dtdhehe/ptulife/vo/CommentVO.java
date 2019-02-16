package com.dtdhehe.ptulife.vo;

import com.dtdhehe.ptulife.entity.Comment;

import java.util.List;
import java.util.Map;

/**
 * Create By Xie_东
 * on 2019/2/12 17:54
 */
public class CommentVO {
    private String id;

    private String content;

    private String createTime;

    private String userId;

    private String userName;

    private String postId;

    private String pid;

    private String replyUserId;

    private List<Map<String,Object>> commentList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(String replyUserId) {
        this.replyUserId = replyUserId;
    }

    public List<Map<String,Object>> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Map<String,Object>> commentList) {
        this.commentList = commentList;
    }
}
