package com.example.travel.Comment_Package;

public class Interpret {
    String nickName;
    String content;
    String time;

    public Interpret(String nickName, String content) {
        this.nickName = nickName;
        this.content = content;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public String getNickName() {
        return nickName;
    }

    public String getTime() {
        return time;
    }
}
