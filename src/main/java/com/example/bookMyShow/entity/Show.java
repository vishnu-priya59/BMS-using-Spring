package com.example.bookMyShow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Show")
public class Show {

    @Id
    private String id;
    private String movieId;
    private String screenId;
    private String startTime;

    public Show(String movieId, String screenId, String startTime) {
        this.movieId = movieId;
        this.screenId = screenId;
        this.startTime = startTime;
    }

    public String getId() {
        return id;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScreenId() {
        return screenId;
    }

    public String getMovieId() {
        return movieId;
    }

    public String toString(){
        return "Show{movieId="+movieId+", screenId="+screenId+", show time='"+startTime+"'}";
    }
}

