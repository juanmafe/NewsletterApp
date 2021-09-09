package com.juanmafe.newsletter.adapters.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.juanmafe.newsletter.adapters.mongo.entities.NewsEntity;

/**
 * News Mongo Repository by Spring Data.
 * @author juanmafe.
 */
public interface NewsRepository extends MongoRepository<NewsEntity, String> {}