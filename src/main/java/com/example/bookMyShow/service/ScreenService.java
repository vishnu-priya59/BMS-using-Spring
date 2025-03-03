package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.Screen;
import com.example.bookMyShow.entity.Theatre;
import com.example.bookMyShow.repo.ScreenRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScreenService {

    private final TheatreService theatreService;
    private final ScreenRepo screenRepo;
    private final SeatService seatService;

    public ScreenService(@Lazy TheatreService theatreService, ScreenRepo screenRepo, @Lazy SeatService seatService) {
        this.theatreService = theatreService;
        this.screenRepo = screenRepo;
        this.seatService = seatService;
    }

    public Screen createScreen(String theatreId, String screenName, int noOfSeats) throws Exception {
        Theatre theatre = theatreService.getTheatreById(theatreId);

        if (theatre == null) {
            throw new Exception("Invalid theatre ID: " + theatreId);
        }

        Screen screen = new Screen(theatre.getId(), screenName, noOfSeats);
        return screenRepo.save(screen);
    }

    public void removeScreen(String screenId) {
        seatService.removeSeatsByScreenId(screenId);
        screenRepo.deleteById(screenId);
    }

    public Screen getScreenById(String screenId) throws Exception {
        return screenRepo.findById(screenId).orElseThrow(() -> new Exception("Screen not found"));
    }

    public List<Screen> getScreenByTheatreId(String theatreId) {
        return screenRepo.findByTheatreId(theatreId);
    }
}
