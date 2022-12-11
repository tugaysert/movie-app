package com.example.movieappbackend.service;

import com.example.movieappbackend.dtos.*;
import com.example.movieappbackend.entity.Movie;
import com.example.movieappbackend.exception.EntityNotFoundException;
import com.example.movieappbackend.exception.ResourceNotFoundException;
import com.example.movieappbackend.repository.MovieRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService{
    private final MovieRepository movieRepository;
    private final Deneme deneme;

    @Override
    public Deneme getDeneme() {
        return deneme;
    }

    public MovieService(MovieRepository movieRepository, Deneme deneme) {
        this.movieRepository = movieRepository;
        this.deneme = deneme;
    }

    @Override
    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    // Create
    @Transactional
    @Override
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
    @Override

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
    @Override

    public GetAllMoviesResponse getAllMovies() {
        List<Movie> movies = movieRepository.findAll();

        GetAllMoviesResponse response = new GetAllMoviesResponse();
        for (Movie movie : movies) {
            GetMovieByIdResponse movieDTO = new GetMovieByIdResponse.GetMovieByIdResponseBuilder().setMovie(movie).build();
            response.addMovie(movieDTO);
        }

        return response;
    }

    @Override
    public void deleteMovie(Long id) {
        Movie movie = this.movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie with id " + id + " not found"));

        this.movieRepository.delete(movie);
    }

    @PostConstruct
    public void addDummyData() {
        Movie movie1 = new Movie.MovieBuilder()
                .setTitle("The Matrix")
                .setDirector("The Wachowskis")
                .setWriter("The Wachowskis")
                .setStar("Keanu Reeves")
                .setGenre("Sci-fi")
                .setYear(1999)
                .build();

        Movie movie2 = new Movie.MovieBuilder()
                .setTitle("The Shawshank Redemption")
                .setDirector("Frank Darabont")
                .setWriter("Stephen King")
                .setStar("Tim Robbins")
                .setGenre("Drama")
                .setYear(1994)
                .build();

        Movie movie3 = new Movie.MovieBuilder()
                .setTitle("Forrest Gump")
                .setDirector("Robert Zemeckis")
                .setWriter("Winston Groom")
                .setStar("Tom Hanks")
                .setGenre("Drama")
                .setYear(1994)
                .build();

        Movie movie4 = new Movie.MovieBuilder()
                .setTitle("Inception")
                .setDirector("Christopher Nolan")
                .setWriter("Christopher Nolan")
                .setStar("Leonardo DiCaprio")
                .setGenre("Sci-fi")
                .setYear(2010)
                .build();

        Movie movie5 = new Movie.MovieBuilder()
                .setTitle("Pulp Fiction")
                .setDirector("Quentin Tarantino")
                .setWriter("Quentin Tarantino")
                .setStar("John Travolta")
                .setGenre("Crime")
                .setYear(1994)
                .build();

        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieRepository.save(movie4);
        movieRepository.save(movie5);




    }

}





