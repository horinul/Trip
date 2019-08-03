package com.example.travel;

public class History_item {
    String name;
    String time;
    int pic_id;//图片ID
    public History_item(String name,String time,int pic_id){
        this.name=name;
        this.pic_id=pic_id;
        this.time=time;
    }
    public String getName(){
        return  name;
    }
    public String getTime(){
        return time;
    }
    public int getPic_id(){
        return pic_id;
    }
}
