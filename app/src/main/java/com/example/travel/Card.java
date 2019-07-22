package com.example.travel;

public class Card {
    private String Introduce;
    private int ImageID;
    public Card(String Introduce,int ImageID){
        this.Introduce=Introduce;
        this.ImageID=ImageID;
    }
    public String getIntroduce(){
        return Introduce;
    }
    public int getImageID(){
        return ImageID;
    }
}
