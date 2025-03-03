package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.Screen;
import com.example.bookMyShow.entity.Seat;
import com.example.bookMyShow.repo.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepo seatRepo;
    private final ScreenService screenService;
    private final SeatCategoryService seatCategoryService;

    @Autowired
    public SeatService(SeatRepo seatRepo, ScreenService screenService, SeatCategoryService seatCategoryService) {
        this.seatRepo = seatRepo;
        this.screenService = screenService;
        this.seatCategoryService = seatCategoryService;
    }

    public Seat createSeat(String screenId, String categoryId) throws Exception {
        Screen screen = screenService.getScreenById(screenId);
        if (screen == null) {
            throw new Exception("Invalid screen ID");
        }

        if (seatCategoryService.getSeatCategoryById(categoryId) == null) {
            throw new Exception("Invalid seat category ID");
        }

        int seatCount = seatRepo.countByScreenId(screenId);
        if (seatCount >= screen.getTotalSeats()) {
            throw new Exception("Cannot add more seats than capacity");
        }

        Seat seat = new Seat(screenId, seatCount + 1);
        return seatRepo.saveSeat(seat);
    }

    public void removeSeat(String seatId) {
        seatRepo.deleteById(seatId);
    }

    public void removeSeatsByScreenId(String screenId) {
        seatRepo.deleteByScreenId(screenId);
    }

    public Seat getSeatBySeatId(String seatId) {
        return seatRepo.findById(seatId);
    }

    public List<Seat> getSeatsByScreenId(String screenId) {
        return seatRepo.findByScreenId(screenId);
    }
}
