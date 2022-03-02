package com.example.csgoapp;

public class Content {

    public final String map;
    public final String grenade;
    public final String side;
    public final String contentTitle;
    public final String videoUrl;
    public final String image1Url;
    public final String image2Url;
    public final String instruction;

    public Content(String contentMap, String contentGrenade, String contentSide, String contentContentTitle, String contentVideoUrl, String contentImage1Url, String contentImage2Url, String instructionString) {
        map=contentMap;
        grenade = contentGrenade;
        side = contentSide;
        contentTitle = contentContentTitle;
        videoUrl = contentVideoUrl;
        image1Url = contentImage1Url;
        image2Url = contentImage2Url;
        instruction = instructionString;
    }


}
