package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.Booking;
import com.example.bookMyShow.entity.PaymentStatus;
import com.example.bookMyShow.entity.Show;
import com.example.bookMyShow.repo.BookingRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepo bookingRepo;
    private final ShowService showService;

    public BookingService(BookingRepo bookingRepo, ShowService showService) {
        this.bookingRepo = bookingRepo;
        this.showService = showService;
    }

    public Booking createBooking(String payId, String showId, PaymentStatus paymentStatus) throws Exception {
        Show show = showService.getShowById(showId);
        if (show == null) {
            throw new Exception("Invalid show ID");
        }

        Booking booking = new Booking(payId, showId, paymentStatus);
        return bookingRepo.savebooking(booking);
    }

    public Booking getBookingById(String bookingId) throws Exception {
        Optional<Booking> booking = bookingRepo.findByBookingId(bookingId);
        if (booking.isPresent()) {
            return booking.get();
        } else {
            throw new Exception("Booking not found");
        }
    }

    public List<Booking> getBookingsByShowId(String showId) {
        return bookingRepo.findByShowId(showId);
    }
}
