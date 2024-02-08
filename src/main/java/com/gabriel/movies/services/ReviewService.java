package com.gabriel.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.gabriel.movies.models.Movie;
import com.gabriel.movies.models.Review;
import com.gabriel.movies.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @SuppressWarnings("null")
    public Review createReview(String reviewBody, String imdbId) {
        Review review = repository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review.getId()))
                .first();

        return review;
    }

}
