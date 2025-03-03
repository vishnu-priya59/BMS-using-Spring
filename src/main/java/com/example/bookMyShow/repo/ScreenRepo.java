package com.example.bookMyShow.repo;

import com.example.bookMyShow.entity.Screen;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScreenRepo {
    private final MongoTemplate mongoTemplate;

    public ScreenRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    public Screen save(Screen screen) {
        return mongoTemplate.insert(screen);
    }


    public List<Screen> findByTheatreId(String theatreId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("theatreId").is(theatreId));
        return mongoTemplate.find(query, Screen.class);
    }


    public void deleteByTheatreId(String theatreId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("theatreId").is(theatreId));
        mongoTemplate.remove(query, Screen.class);
    }


    public Optional<Screen> findById(String screenId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(screenId));
        return Optional.ofNullable(mongoTemplate.findOne(query, Screen.class));
    }


    public void deleteById(String screenId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(screenId));
        mongoTemplate.remove(query, Screen.class);
    }


}
