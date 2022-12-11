package com.example.movieappbackend;

import com.example.movieappbackend.configuration.MovieServiceConfiguration;
import com.example.movieappbackend.controller.MovieController;
import com.example.movieappbackend.repository.MovieRepository;
import com.example.movieappbackend.service.IMovieService;
import com.example.movieappbackend.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class MovieAppBackendApplication {


    private static Logger LOGGER = LoggerFactory.getLogger(MovieAppBackendApplication.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(MovieAppBackendApplication.class, args);
        MovieRepository movieRepository = applicationContext.getBean(MovieRepository.class);
        MovieService movieService1 = applicationContext.getBean(MovieService.class);
        LOGGER.info("{}", movieService1);
        LOGGER.info("{}", movieService1.getDeneme());

        movieRepository.findAll().stream().forEach(movie -> System.out.println(movie.getTitle()));

        MovieController movieController = applicationContext.getBean(MovieController.class);
        System.out.println(movieController.getUrl());

        MovieServiceConfiguration conf = applicationContext.getBean(MovieServiceConfiguration.class);
        System.out.println(conf.getUsername());

    }

}
