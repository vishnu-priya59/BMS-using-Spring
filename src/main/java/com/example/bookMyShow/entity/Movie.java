package com.example.bookMyShow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@org.springframework.data.mongodb.core.mapping.Document(collection = "movie")
@Document(indexName = "movies")
public class Movie implements IPersistent {

    @Id
    private String id;
    private String duration;

    @Field(type = FieldType.Text, analyzer = "standard")
    private String title;

    @Field(type = FieldType.Text, analyzer = "standard")
    private String description;

    private GenreType genreType;
    private String directorName;

    private double averageRating;
    private int reviewCount;


    public Movie(String title, String duration, String description, String directorName) {
        this.duration = duration;
        this.title = title;
        this.description = description;
        this.directorName = directorName;
    }

    @Override
    public String toString() {
        return "Movie{duration=" + duration + ", title='" + title + "', genreType='" + genreType + "', directorName='" + directorName + "'}";
    }


    @Override
    public void setId(String Id) {

    }

    public String getId(String Id){
        return Id;
    }

    public void decrementReviewCount() {
        this.reviewCount--;
    }
}

