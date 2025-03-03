package com.example.bookMyShow.controller;

import com.example.bookMyShow.dto.SeatRequest;
import com.example.bookMyShow.entity.Seat;
import com.example.bookMyShow.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping("/create")
    public Seat createSeat(@RequestBody SeatRequest seatRequest) throws Exception {
        return seatService.createSeat(seatRequest.getScreenId(), seatRequest.getCategoryId());
    }

    @GetMapping("/getSeatBySeatId/{seatId}")
    public Seat getSeatBySeatId(@PathVariable String seatId){
        return seatService.getSeatBySeatId(seatId);
    }

    @GetMapping("/getSeatsByScreenId/{screenId}")
    public List<Seat> getSeatsByScreenId(@PathVariable String screenId){
        return seatService.getSeatsByScreenId(screenId);
    }
}

