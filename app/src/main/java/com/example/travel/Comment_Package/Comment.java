package com.example.travel.Comment_Package;

import java.util.List;

public class Comment {
    private int code;
    private String message;
    private Data data;

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public class Data {
        private int total;
        private List<CommentDetial> list;
        private void setTotal(int total) {
            this.total = total;
        }

        public int getTotal() {
            return total;
        }

        public void setList(List<CommentDetial> list) {
            this.list = list;
        }

        public List<CommentDetial> getList() {
            return list;
        }
    }
}
