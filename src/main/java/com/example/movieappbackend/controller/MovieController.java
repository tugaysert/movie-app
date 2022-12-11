package com.example.movieappbackend.controller;

import com.example.movieappbackend.dtos.*;
import com.example.movieappbackend.entity.Movie;
import com.example.movieappbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Value("${external.service.url}")
    private String url;

    public String getUrl() {
        return url;
    }

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public CreateMovieResponse createMovie(@RequestBody CreateMovieRequest request) {
        return this.movieService.createMovie(request);
    }

    @GetMapping("/{id}")
    public GetMovieByIdResponse getMovieById(@PathVariable("id") Long id) {
        return this.movieService.getMovieById(id);
    }

    @PutMapping("/{id}")
    public UpdateMovieResponse updateMovie(@PathVariable("id") Long id, @RequestBody UpdateMovieRequest request) {
        return this.movieService.updateMovie(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {
        this.movieService.deleteMovie(id);
    }
}