package com.example.movieappbackend.entity;


import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "_movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "_title")
    @NotNull
    @Size(min = 1, max = 100)
    private String title;

    @Column(name = "_director")
    @NotNull
    @Size(min = 1, max = 100)
    private String director;

    @Column(name = "_writer")
    @NotNull
    @Size(min = 1, max = 100)
    private String writer;

    @Column(name = "_star")
    @NotNull
    @Size(min = 1, max = 100)
    private String star;

    @Column(name = "_genre")
    @NotNull
    @Size(min = 1, max = 100)
    private String genre;

    @Column(name = "_year")
    @NotNull
    private int year;


    public Movie() { }

    private Movie(MovieBuilder builder) {
        this.title = builder.title;
        this.director = builder.director;
        this.writer = builder.writer;
        this.star = builder.star;
        this.genre = builder.genre;
        this.year = builder.year;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDirector() {
        return this.director;
    }

    public String getWriter() {
        return this.writer;
    }

    public String getStar() {
        return this.star;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getYear() {
        return this.year;
    }

    public static class MovieBuilder {
        private String title;
        private String director;
        private String writer;
        private String star;
        private String genre;
        private int year;


        public MovieBuilder() { }
        public MovieBuilder(Movie movie) {
            this.title = movie.getTitle();
            this.director = movie.getDirector();
            this.writer = movie.getWriter();
            this.star = movie.getStar();
            this.genre = movie.getGenre();
            this.year = movie.getYear();
        }
        public MovieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder setDirector(String director) {
            this.director = director;
            return this;
        }

        public MovieBuilder setWriter(String writer) {
            this.writer = writer;
            return this;
        }

        public MovieBuilder setStar(String star) {
            this.star = star;
            return this;
        }

        public MovieBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public MovieBuilder setYear(int year) {
            this.year = year;
            return this;
        }



        public Movie build() {
            return new Movie(this);
        }
    }
}

