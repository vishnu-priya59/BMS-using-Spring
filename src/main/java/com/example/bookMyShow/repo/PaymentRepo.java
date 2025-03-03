package com.example.bookMyShow.repo;

import com.example.bookMyShow.entity.Payment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepo {
    private final MongoTemplate mongoTemplate;

    public PaymentRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public Payment save(Payment payment) {
        return mongoTemplate.save(payment);
    }


    public Payment findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Payment.class);
    }


    public List<Payment> findAll() {
        return mongoTemplate.findAll(Payment.class);
    }


    public Payment update(Payment payment) {
        return mongoTemplate.save(payment);
    }


    public void deleteById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Payment.class);
    }
}
