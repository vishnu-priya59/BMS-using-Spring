package com.example.bookMyShow.controller;


import com.example.bookMyShow.dto.MovieRequest;
import com.example.bookMyShow.entity.Movie;
import com.example.bookMyShow.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/create")
    public Movie createMovie(@RequestBody MovieRequest movieRequest){
        return movieService.createMovie(movieRequest.getDuration(), movieRequest.getMovieName(), movieRequest.getDescription(), movieRequest.getGenreType(), movieRequest.getDirectorName());
    }

    @GetMapping("/getMovieById/{movieId}")
    public Movie getMovieById(@PathVariable String movieId) throws Exception {
        return movieService.getMovieById(movieId);
    }

    @PostMapping("/removeMovie/{movieId}")
    public boolean removeMovie(@PathVariable String movieId){
        return movieService.removeMovie(movieId);
    }
}