package com.example.movieappbackend;

import com.example.movieappbackend.dtos.CreateMovieRequest;

import com.example.movieappbackend.entity.Detail;
import com.example.movieappbackend.repository.MovieRepository;
import com.example.movieappbackend.service.MovieService;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class MovieAppBackendApplication implements CommandLineRunner {


    //private static Logger LOGGER = LoggerFactory.getLogger(MovieAppBackendApplication.class);
    private  Logger logger = LoggerFactory.getLogger(MovieAppBackendApplication.class);
    private final MovieService movieService;
    private final MovieRepository movieRepository;

    public MovieAppBackendApplication(MovieService movieService, MovieRepository movieRepository) {
        this.movieService = movieService;
        this.movieRepository = movieRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieAppBackendApplication.class, args);
/*      ApplicationContext applicationContext = SpringApplication.run(MovieAppBackendApplication.class, args);
        MovieRepository movieRepository = applicationContext.getBean(MovieRepository.class);
        MovieService movieService1 = applicationContext.getBean(MovieService.class);
        LOGGER.info("{}", movieService1);
        LOGGER.info("{}", movieService1.getDeneme());

        movieRepository.findAll().stream().forEach(movie -> System.out.println(movie.getTitle()));

        MovieController movieController = applicationContext.getBean(MovieController.class);
        System.out.println(movieController.getUrl());

        MovieServiceConfiguration conf = applicationContext.getBean(MovieServiceConfiguration.class);
        System.out.println(conf.getUsername());*/

    }

    @Override
    public void run(String... args) throws Exception {

        movieService.getAllMovies().getMovies().stream().forEach(getMovieByIdResponse -> System.out.println(getMovieByIdResponse.getMovie().getTitle()));
        System.out.println(movieService.getMovieById(1L).getMovie().getTitle());
        movieService.countTrackTime();
        CreateMovieRequest request = new CreateMovieRequest.CreateMovieRequestBuilder()
                .setTitle("Movie Title")
                .setDirector("Movie Director")
                .setWriter("Movie Writer")
                .setStar("Movie Star")
                .setGenre("Movie Genre")
                .setYear(2020)
                .setDetail(new Detail("KASJDIOKSHADLOIKSADJJHASD"))
                .build();
        movieService.createMovie(request);
        //System.out.println(movieService.getMovieById(9999L).getMovie().getTitle());;
    }
}
