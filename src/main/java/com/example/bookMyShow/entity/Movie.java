package com.example.bookMyShow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Movie")
public class Movie {

    @Id
    private String id;
    private String duration;
    private String name;
    private String description;
    private GenreType genreType;
    private String directorName;


    public Movie(String name, String duration, String description, GenreType genreType, String directorName) {
        this.duration = duration;
        this.name = name;
        this.description = description;
        this.genreType = genreType;
        this.directorName = directorName;
    }

    public String getId() {
        return id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GenreType getGenreType() {
        return genreType;
    }

    public void setGenreType(GenreType genreType) {
        this.genreType = genreType;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "Movie{duration="+duration+", name='"+name+"', genreType='"+genreType+"', directorName='"+directorName+"'}";
    }
}

