package com.example.bookMyShow.service;

import com.example.bookMyShow.entity.Movie;
import com.example.bookMyShow.entity.IPersistent;
import com.example.bookMyShow.repo.MovieElasticsearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersistentService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MovieElasticsearchRepository movieElasticsearchRepository;

    public void save(IPersistent entity) {
        if (entity instanceof Movie) {
            movieElasticsearchRepository.save((Movie) entity);
            mongoTemplate.save(entity);
        } else {
            mongoTemplate.save(entity);
        }
    }

}
