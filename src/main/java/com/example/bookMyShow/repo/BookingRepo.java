package com.example.bookMyShow.repo;

import com.example.bookMyShow.entity.Booking;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public class BookingRepo {
    private final MongoTemplate mongoTemplate;

    public BookingRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Booking savebooking(Booking booking) {
        return mongoTemplate.insert(booking);
    }


    public Optional<Booking> findByBookingId(String bookingId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(bookingId));
        return Optional.ofNullable(mongoTemplate.findOne(query, Booking.class));
    }


    public List<Booking> findByShowId(String showId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("showId").is(showId));
        return mongoTemplate.find(query, Booking.class);
    }
}
