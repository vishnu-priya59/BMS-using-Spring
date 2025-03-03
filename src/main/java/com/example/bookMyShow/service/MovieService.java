package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.GenreType;
import com.example.bookMyShow.entity.Movie;
import com.example.bookMyShow.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public Movie createMovie(String duration, String movieName, String description, GenreType genreType, String directorName) {
        Movie movie = new Movie(duration, movieName, description, genreType, directorName);
        return movieRepo.saveMovie(movie);
    }

    public Movie getMovieById(String movieId) throws Exception {
        Optional<Movie> movie = movieRepo.findById(movieId);
        if (movie.isPresent()) {
            return movie.get();
        } else {
            throw new Exception("Movie not found");
        }
    }

    public boolean removeMovie(String movieId) {
        if (movieRepo.existsById(movieId)) {
            movieRepo.deleteById(movieId);
            return true;
        }
        return false;
    }
}
