package com.example.bookMyShow.controller;

import com.example.bookMyShow.dto.*;
import com.example.bookMyShow.entity.*;
import com.example.bookMyShow.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/createTheatre")
    public Theatre createtheatre(@RequestBody TheatreRequest theatreRequest) {

        return adminService.createTheatre(theatreRequest.getName(), theatreRequest.getAddress());
    }

    @PostMapping("/createScreen")
    public Screen createScreen(@RequestBody ScreenRequest screenRequest) throws Exception {
        return adminService.createScreen(screenRequest.getTheatreId(), screenRequest.getName(), screenRequest.getTotalSeats());
    }

    @PostMapping("/createShow")
    public Show createShow(@RequestBody ShowRequest showRequest) throws Exception {
        return adminService.createShow(showRequest.getMovieId(), showRequest.getScreenId(), showRequest.getShowTime());
    }

    @PostMapping("/createSeatCategory/{price}")
    public SeatCategory createSeatCategory(@PathVariable int price) {
        return adminService.createSeatCategory(price);
    }

    @PostMapping("/createSeat")
    public Seat createSeat(@RequestBody SeatRequest seatRequest) throws Exception {
        return adminService.createSeat(seatRequest.getScreenId(), seatRequest.getCategoryId());
    }


}
