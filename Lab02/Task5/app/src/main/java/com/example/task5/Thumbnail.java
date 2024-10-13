package com.example.task5;

public class Thumbnail {
    String thumbNum;
    int thumbPic;

    public Thumbnail(String thumbNum, int thumbPic) {
        this.thumbNum = thumbNum;
        this.thumbPic = thumbPic;
    }

    public String getThumbNum() {
        return thumbNum;
    }

    public int getThumbPic() {
        return thumbPic;
    }
}