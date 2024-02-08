package com.gabriel.movies.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.gabriel.movies.models.Review;

public interface ReviewRepository extends MongoRepository<Review, ObjectId>{
    
}
