package com.example.travel.Comment_Package;

import java.util.List;

public class CommentDetial {
    private int id;
    private String nickName;
    private String userLogo;
    private String content;
    private String imgId;
    private int replyTotal;
    private String createDate;
    private List<ReplyDetail> replyDetailList;

    public CommentDetial(String nickName, String content, String createDate) {
        this.nickName = nickName;
        this.content = content;
        this.createDate = createDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgId() {
        return imgId;
    }

    public void setReplyTotal(int replyTotal) {
        this.replyTotal = replyTotal;
    }

    public int getReplyTotal() {
        return replyTotal;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setReplylist(List<ReplyDetail> replyDetailList) {
        this.replyDetailList = replyDetailList;
    }

    public List<ReplyDetail> getReplyDetailList() {
        return replyDetailList;
    }
}
