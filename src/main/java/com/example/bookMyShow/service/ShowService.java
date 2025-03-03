package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.Show;
import com.example.bookMyShow.repo.ShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private final ShowRepo showRepo;
    private final MovieService movieService;
    private final ScreenService screenService;

    @Autowired
    public ShowService(ShowRepo showRepo, MovieService movieService, ScreenService screenService) {
        this.showRepo = showRepo;
        this.movieService = movieService;
        this.screenService = screenService;
    }

    public Show createShow(String movieId, String screenId, String showTime) throws Exception {
        if (movieService.getMovieById(movieId) == null) {
            throw new Exception("Invalid movie ID");
        }

        if (screenService.getScreenById(screenId) == null) {
            throw new Exception("Invalid screen ID");
        }

        Show show = new Show(movieId, screenId, showTime);
        return showRepo.saveShow(show);
    }

    public Show getShowById(String showId) {
        return showRepo.findById(showId);
    }

    public List<Show> getShowsByScreenId(String screenId) {
        return showRepo.findByScreenId(screenId);
    }
}
