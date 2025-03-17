package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.Movie;
import com.example.bookMyShow.repo.MovieElasticsearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElasticSearchService {

    @Autowired
    private MovieElasticsearchRepository movieElasticsearchRepository;

    public void saveMovie(Movie movie) {
        movieElasticsearchRepository.save(movie);
    }

    public List<Movie> searchMovies(String query) {
        return movieElasticsearchRepository.searchMovies(query);
    }

    public Movie getMovieById(String id) {
        Optional<Movie> movie = movieElasticsearchRepository.findById(id);
        return movie.orElse(null);
    }

    public void deleteMovie(String id) {
        movieElasticsearchRepository.deleteById(id);
    }
}
