package com.example.bookMyShow.repo;

import com.example.bookMyShow.entity.SeatCategory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatCategoryRepo {
    private final MongoTemplate mongoTemplate;

    public SeatCategoryRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public SeatCategory save(SeatCategory seatCategory) {
        return mongoTemplate.save(seatCategory);
    }


    public SeatCategory findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, SeatCategory.class);
    }


    public List<SeatCategory> findAll() {
        return mongoTemplate.findAll(SeatCategory.class);
    }


    public SeatCategory update(SeatCategory seatCategory) {
        return mongoTemplate.save(seatCategory);
    }


    public void deleteById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, SeatCategory.class);
    }
}
