package com.example.bookMyShow.repo;

import com.example.bookMyShow.entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {

    private final MongoTemplate mongoTemplate;


    public UserRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public User save(User user) {
        return mongoTemplate.save(user);
    }


    public User findByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        return mongoTemplate.findOne(query, User.class);
    }


    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    public void deleteByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        mongoTemplate.remove(query, User.class);
    }
}
