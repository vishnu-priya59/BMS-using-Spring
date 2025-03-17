package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.*;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final TheatreService theatreService;
    private final ScreenService screenService;
    private final ShowService showService;
    private final SeatService seatService;
    private final MovieService movieService;
    private final SeatCategoryService seatCategoryService;

    public AdminService(TheatreService theatreService, ScreenService screenService, ShowService showService, SeatService seatService, MovieService movieService, SeatCategoryService seatCategoryService) {
        this.theatreService = theatreService;
        this.screenService = screenService;
        this.showService = showService;
        this.seatService = seatService;
        this.movieService = movieService;
        this.seatCategoryService = seatCategoryService;
    }

    public Theatre createTheatre(String name, String address) {
        return theatreService.createTheatre(name, address);
    }


    public Screen createScreen(String theatreId, String name, int totalSeats) throws Exception {
        return screenService.createScreen(theatreId, name, totalSeats);
    }


    public Show createShow(String movieId, String screenId, String startTime) throws Exception {

        return showService.createShow(movieId, screenId, startTime);

    }

    public SeatCategory createSeatCategory(int price){
        return seatCategoryService.createCategory(price);
    }

    public Seat createSeat(String screenId, String categoryId) throws Exception {
        return seatService.createSeat(screenId, categoryId);
    }

   public Movie createMovie(String name, String duration, String description, GenreType genreType, String directorName){
        return movieService.createMovie(duration, name, description,genreType, directorName);
    }

}
