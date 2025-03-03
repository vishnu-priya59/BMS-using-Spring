package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.Screen;
import com.example.bookMyShow.entity.Theatre;
import com.example.bookMyShow.repo.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    private final TheatreRepo theatreRepo;
    private final ScreenService screenService;

    @Autowired
    public TheatreService(TheatreRepo theatreRepo, ScreenService screenService) {
        this.theatreRepo = theatreRepo;
        this.screenService = screenService;
    }

    public Theatre createTheatre(String theatreName, String address) {
        Theatre theatre = new Theatre(theatreName, address);
        return theatreRepo.saveTheatre(theatre);
    }

    public void removeTheatre(String theatreId) {
        List<Screen> screens = screenService.getScreenByTheatreId(theatreId);
        screens.forEach(screen -> screenService.removeScreen(screen.getId()));
        theatreRepo.deleteById(theatreId);
    }

    public Theatre getTheatreById(String theatreId) {
        return theatreRepo.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("Theatre not found with ID: " + theatreId));
    }

    public List<Theatre> getTheatres() {
        return theatreRepo.findAll();
    }
}
