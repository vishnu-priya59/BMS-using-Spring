package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.GenreType;
import com.example.bookMyShow.entity.Movie;
import com.example.bookMyShow.repo.MovieElasticsearchRepository;
import com.example.bookMyShow.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieElasticsearchRepository movieElasticsearchRepository;

    @Autowired
    private MovieRepo movieRepo;

    public Movie createMovie(Movie movie) {
        Movie createdMovie = movieRepo.save(movie);
        movieElasticsearchRepository.save(createdMovie);
        return createdMovie;
    }

    public Movie getMovieById(String movieId) {

        Movie movie = movieElasticsearchRepository.findById(movieId).orElse(null);
        if (movie == null) {
            movie = movieRepo.findById(movieId).orElse(null);
        }
        return movie;
    }

    public Movie updateMovie(String id, Movie updatedMovie) {
        Optional<Movie> existingMovie = movieRepo.findById(id);
        if (existingMovie.isPresent()) {
            Movie movie = existingMovie.get();
            movie.setTitle(updatedMovie.getTitle());
            movie.setDescription(updatedMovie.getDescription());
            movie.setGenreType(updatedMovie.getGenreType());
            movie.setDuration(updatedMovie.getDuration());
            movieRepo.save(movie);
            movieElasticsearchRepository.save(movie);
            return movie;
        }
        return null;
    }

    public boolean removeMovie(String movieId) {
        if (movieRepo.existsById(movieId)) {
            movieRepo.deleteById(movieId);
            movieElasticsearchRepository.deleteById(movieId);
            return true;
        }
        return false;
    }

    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    public List<Movie> searchMovies(String query) {
        return movieElasticsearchRepository.searchMovies(query);
    }



    public void updateMovieFromReviewEvent(String movieId, int rating) {
        Movie movie = movieRepo.findById(movieId).orElse(null);
        if (movie != null) {
            movie.setAverageRating(calculateNewAverage(movie.getAverageRating(), rating)); // Implement this method
            movieRepo.save(movie);
        }
    }

    private double calculateNewAverage(double currentAverage, int newRating) {
        return (currentAverage + newRating) / 2;
    }

    public void removeReviewFromMovie(String movieId) {
        Movie movie = movieRepo.findById(movieId).orElse(null);
        if (movie != null) {
            movie.decrementReviewCount();
            movieRepo.save(movie);
        }
    }

    public Movie createMovie(String duration, String name, String description, GenreType genreType, String directorName) {
        return null;
    }
}
