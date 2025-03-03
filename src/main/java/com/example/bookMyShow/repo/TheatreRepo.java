package com.example.bookMyShow.repo;

import com.example.bookMyShow.entity.Theatre;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TheatreRepo {
    private final MongoTemplate mongoTemplate;

    public TheatreRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Theatre saveTheatre(Theatre theatre) {
        return mongoTemplate.insert(theatre);
    }

    public void deleteById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Theatre.class);
    }

    public Optional<Theatre> findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return Optional.ofNullable(mongoTemplate.findOne(query, Theatre.class));
    }

    public List<Theatre> findAll() {
        return mongoTemplate.findAll(Theatre.class);
    }
}
