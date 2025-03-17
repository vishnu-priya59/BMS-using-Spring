package com.example.bookMyShow.kafka;


import com.example.bookMyShow.entity.Movie;
import com.example.bookMyShow.repo.MovieRepo;
import com.example.bookMyShow.service.MovieService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MovieEventConsumer {

    private final MovieService movieService;
    private final MovieRepo movieRepo;

    @Autowired
    public MovieEventConsumer(MovieService movieService, MovieRepo movieRepo) {
        this.movieService = movieService;
        this.movieRepo = movieRepo;
    }

    @KafkaListener(topics = "${spring.kafka.topic.review-events}", groupId = "bookMyShow-group")
    public void handleReviewEvent(String reviewEvent) {
        JSONObject reviewJson = new JSONObject(reviewEvent);
        String movieId = reviewJson.getString("movieId");
        int rating = reviewJson.getInt("rating");
        String eventType = reviewJson.getString("eventType");

        switch (eventType) {
            case "created":
            case "updated":
                updateMovieAverageRating(movieId, rating);
                break;
            case "deleted":
                removeReviewFromMovie(movieId);
                break;
        }
    }

    private void updateMovieAverageRating(String movieId, int newRating) {
        Movie movie = movieRepo.findById(movieId).orElse(null);
        if (movie != null) {
            double currentAverage = movie.getAverageRating();
            int reviewCount = movie.getReviewCount();
            double newAverage = ((currentAverage * reviewCount) + newRating) / (reviewCount + 1);
            movie.setAverageRating(newAverage);
            movie.setReviewCount(reviewCount + 1);
            movieRepo.save(movie);
        }
    }

    private void removeReviewFromMovie(String movieId) {
        Movie movie = movieRepo.findById(movieId).orElse(null);
        if (movie != null) {
            if (movie.getReviewCount() > 0) {
                movie.setReviewCount(movie.getReviewCount() - 1);
            }
            movieRepo.save(movie);
        }
    }
}
