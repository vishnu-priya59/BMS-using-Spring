package com.example.bookMyShow.repo;

import com.example.bookMyShow.entity.Seat;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatRepo {
    private final MongoTemplate mongoTemplate;

    public SeatRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Seat saveSeat(Seat seat) {
        return mongoTemplate.insert(seat);
    }


    public List<Seat> findByScreenId(String screenId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("screenId").is(screenId));
        return mongoTemplate.find(query, Seat.class);
    }


    public void deleteById(String seatId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(seatId));
        mongoTemplate.remove(query, Seat.class);
    }


    public void deleteByScreenId(String screenId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("screenId").is(screenId));
        mongoTemplate.remove(query, Seat.class);
    }


    public int countByScreenId(String screenId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("screenId").is(screenId));
        return (int) mongoTemplate.count(query, Seat.class);
    }


    public Seat findById(String seatId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(seatId));
        return mongoTemplate.findOne(query, Seat.class);
    }
}
