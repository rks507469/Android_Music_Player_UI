package com.practice.musicplayer.Models;

public class SongCardModel {
    //change the data type of image to string when accessing the online images
    private int image;
    private String songName;

    //constructor of the class
    public SongCardModel(int image, String songName) {
        this.image = image;
        this.songName = songName;
    }

    //getters and setter
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}
