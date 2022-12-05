package com.example.movieappbackend.service;

import com.example.movieappbackend.dtos.*;
import com.example.movieappbackend.entity.Movie;
import com.example.movieappbackend.exception.EntityNotFoundException;
import com.example.movieappbackend.exception.ResourceNotFoundException;
import com.example.movieappbackend.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Create
    @Transactional
    public CreateMovieResponse createMovie(CreateMovieRequest createMovieRequest) {
        Movie movie = new Movie.MovieBuilder()
                .setTitle(createMovieRequest.getTitle())
                .setDirector(createMovieRequest.getDirector())
                .setWriter(createMovieRequest.getWriter())
                .setStar(createMovieRequest.getStar())
                .setGenre(createMovieRequest.getGenre())
                .setYear(createMovieRequest.getYear())
                .build();
        movie = movieRepository.save(movie);
        return new CreateMovieResponse()
                .setId(movie.getId())
                .setTitle(movie.getTitle())
                .setDirector(movie.getDirector())
                .setWriter(movie.getWriter())
                .setStar(movie.getStar())
                .setGenre(movie.getGenre())
                .setYear(movie.getYear());
    }

    // Read
    public GetMovieByIdResponse getMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        return new GetMovieByIdResponse.GetMovieByIdResponseBuilder().setMovie(movie).build();
    }

    // Update
    @Transactional
    public UpdateMovieResponse updateMovie(Long id, UpdateMovieRequest request) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie with id " + id + " not found"));
        movie = new Movie.MovieBuilder(movie)
                .setTitle(request.getTitle())
                .setDirector(request.getDirector())
                .setWriter(request.getWriter())
                .setStar(request.getStar())
                .setGenre(request.getGenre())
                .setYear(request.getYear())
                .build();
        movieRepository.save(movie);

        return new UpdateMovieResponse()
                .setId(movie.getId())
                .setTitle(movie.getTitle())
                .setDirector(movie.getDirector())
                .setWriter(movie.getWriter())
                .setStar(movie.getStar())
                .setGenre(movie.getGenre())
                .setYear(movie.getYear());
    }

    public GetAllMoviesResponse getAllMovies() {
        List<Movie> movies = movieRepository.findAll();

        GetAllMoviesResponse response = new GetAllMoviesResponse();
        for (Movie movie : movies) {
            GetMovieByIdResponse movieDTO = new GetMovieByIdResponse.GetMovieByIdResponseBuilder().setMovie(movie).build();
            response.addMovie(movieDTO);
        }

        return response;
    }

    public void deleteMovie(Long id) {
        Movie movie = this.movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie with id " + id + " not found"));

        this.movieRepository.delete(movie);
    }
}





