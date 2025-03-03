package com.example.bookMyShow.repo;

import com.example.bookMyShow.entity.Show;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShowRepo {
    private final MongoTemplate mongoTemplate;

    public ShowRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Show> findByScreenId(String screenId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("screenId").is(screenId));
        return mongoTemplate.find(query, Show.class);
    }

    public Show saveShow(Show show) {
        return mongoTemplate.insert(show);
    }

    public Show findById(String showId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(showId));
        return mongoTemplate.findOne(query, Show.class);
    }
}
