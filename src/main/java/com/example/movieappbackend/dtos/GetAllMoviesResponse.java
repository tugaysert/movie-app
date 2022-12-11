package com.example.movieappbackend.dtos;

import com.example.movieappbackend.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class GetAllMoviesResponse {
    private List<GetMovieByIdResponse> movies;

    public GetAllMoviesResponse() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(GetMovieByIdResponse movie) {
        this.movies.add(movie);
    }

    public List<GetMovieByIdResponse> getMovies() {
        return this.movies;
    }


}