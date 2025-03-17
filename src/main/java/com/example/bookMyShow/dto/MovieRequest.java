package com.example.bookMyShow.dto;

import com.example.bookMyShow.entity.GenreType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class MovieRequest {
    String duration;
    String movieName;
    String description;
    GenreType genreType;
    String directorName;

}
