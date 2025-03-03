package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.SeatBooking;
import com.example.bookMyShow.repo.SeatBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatBookingService {

    private final SeatService seatService;
    private final BookingService bookingService;
    private final SeatBookingRepo seatBookingRepo;

    @Autowired
    public SeatBookingService(SeatService seatService, BookingService bookingService, SeatBookingRepo seatBookingRepo) {
        this.seatService = seatService;
        this.bookingService = bookingService;
        this.seatBookingRepo = seatBookingRepo;
    }

    public SeatBooking createSeatBooking(String seatId, String bookingId) throws Exception {
        if (seatService.getSeatBySeatId(seatId) == null) {
            throw new Exception("Invalid seat ID");
        }
        if (bookingService.getBookingById(bookingId) == null) {
            throw new Exception("Invalid booking ID");
        }
        SeatBooking seatBooking = new SeatBooking(seatId, bookingId);
        return seatBookingRepo.save(seatBooking);
    }

    public List<SeatBooking> getSeatBookingsByBookingId(String bookingId) {
        return seatBookingRepo.findByBookingId(bookingId);
    }
}
