package com.example.bookMyShow.controller;

import com.example.bookMyShow.dto.BookingRequest;
import com.example.bookMyShow.entity.Booking;
import com.example.bookMyShow.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savebooking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public Booking createBooking(@RequestBody BookingRequest bookingRequest) throws Exception {
        return bookingService.createBooking(bookingRequest.getPayId(), bookingRequest.getShowId(), bookingRequest.getPaymentStatus());
    }

    @GetMapping("/getBookingById/{bookingId}")
    public Booking getBookingById(@PathVariable String bookingId) throws Exception{
        return bookingService.getBookingById(bookingId);
    }

    @GetMapping("/getBookingsByShowId/{showId}")
    public List<Booking> getBookingsByShowId(@PathVariable String showId){
        return bookingService.getBookingsByShowId(showId);
    }

}


