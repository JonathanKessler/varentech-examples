package com.varentech.entities;

/**
 * Created by ParksW on 5/25/2016.
 */
public class Music {
    private int id;
    private int year;
    private String artistName;
    private String albumName;

    public Music(){

    }

    public Music(String artistName, String albumName, int year){
        this.artistName = artistName;
        this.albumName = albumName;
        this.year = year;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getId(){
        return id;
    }

    public int getYear(){
        return year;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }
}
