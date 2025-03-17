package com.example.bookMyShow.repo;

import com.example.bookMyShow.entity.Movie;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepo {
    private final MongoTemplate mongoTemplate;

    public MovieRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Movie save(Movie movie) {
        return mongoTemplate.save(movie);
    }

    public Optional<Movie> findById(String movieId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(movieId));
        return Optional.ofNullable(mongoTemplate.findOne(query, Movie.class));
    }

    public boolean existsById(String movieId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(movieId));
        return mongoTemplate.exists(query, Movie.class);
    }

    public void deleteById(String movieId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(movieId));
        mongoTemplate.remove(query, Movie.class);
    }

    public List<Movie> findAll() {
        return mongoTemplate.findAll(Movie.class);
    }
}
