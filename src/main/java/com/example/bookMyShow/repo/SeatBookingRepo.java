package com.example.bookMyShow.repo;

import com.example.bookMyShow.entity.SeatBooking;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatBookingRepo {
    private final MongoTemplate mongoTemplate;

    public SeatBookingRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public SeatBooking save(SeatBooking seatBooking) {
        return mongoTemplate.save(seatBooking);
    }

    public SeatBooking findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, SeatBooking.class);
    }

    public List<SeatBooking> findAll() {
        return mongoTemplate.findAll(SeatBooking.class);
    }

    public List<SeatBooking> findByBookingId(String bookingId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("bookingId").is(bookingId));
        return mongoTemplate.find(query, SeatBooking.class);
    }

    public void deleteById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, SeatBooking.class);
    }
}
