package com.example.movieappbackend.service;

import com.example.movieappbackend.dtos.CreateMovieRequest;
import com.example.movieappbackend.dtos.CreateMovieResponse;
import com.example.movieappbackend.dtos.GetAllMoviesResponse;
import com.example.movieappbackend.dtos.GetMovieByIdResponse;
import com.example.movieappbackend.repository.MovieRepository;
import jakarta.transaction.Transactional;

public interface IMovieService {
    Deneme getDeneme();

    MovieRepository getMovieRepository();

    // Create
    @Transactional
    CreateMovieResponse createMovie(CreateMovieRequest createMovieRequest);

    // Read
    GetMovieByIdResponse getMovieById(Long id);

    GetAllMoviesResponse getAllMovies();

    void deleteMovie(Long id);
}
