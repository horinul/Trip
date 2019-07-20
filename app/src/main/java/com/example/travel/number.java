package com.example.travel;

public class number {
    private String intro;
    private int ImageID;
    public number(String intro, int ImageID){
        this.intro=intro;
        this.ImageID=ImageID;
    }
    public String getIntro(){
        return intro;
    }
    public int getImageID(){
        return ImageID;
    }
}
