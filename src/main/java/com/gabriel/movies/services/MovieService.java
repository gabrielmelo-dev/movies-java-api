package com.gabriel.movies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.movies.models.Movie;
import com.gabriel.movies.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<Movie> findMovieByImdbId(String imdbId){
        return repository.findMovieByImdbId(imdbId);
    }

}
