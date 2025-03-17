package com.example.bookMyShow.repo;

import com.example.bookMyShow.entity.Movie;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MovieElasticsearchRepository {
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    public List<Movie> searchMovies(String query) {
        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(query, "title", "description"))
                .build();

        SearchHits<Movie> searchHits = elasticsearchOperations.search(searchQuery, Movie.class, IndexCoordinates.of("movies"));
        return searchHits.stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }

    public void save(Movie movie) {
        elasticsearchOperations.save(movie, IndexCoordinates.of("movies"));
    }

    public Optional<Movie> findById(String id) {
        return Optional.ofNullable(elasticsearchOperations.get(id, Movie.class, IndexCoordinates.of("movies")));
    }

    public void deleteById(String id) {
        elasticsearchOperations.delete(id, String.valueOf(Movie.class), IndexCoordinates.of("movies"));
    }
}
