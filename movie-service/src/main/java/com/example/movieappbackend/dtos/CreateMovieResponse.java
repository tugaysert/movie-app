package com.example.movieappbackend.dtos;

public class CreateMovieResponse {
    private Long id;
    private String title;
    private String director;
    private String writer;
    private String star;
    private String genre;
    private int year;

    public CreateMovieResponse() { }

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

    public CreateMovieResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public CreateMovieResponse setTitle(String title) {
        this.title = title;
        return this;
    }

    public CreateMovieResponse setDirector(String director) {
        this.director = director;
        return this;
    }

    public CreateMovieResponse setWriter(String writer) {
        this.writer = writer;
        return this;
    }

    public CreateMovieResponse setStar(String star) {
        this.star = star;
        return this;
    }

    public CreateMovieResponse setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public CreateMovieResponse setYear(int year) {
        this.year = year;
        return this;
    }
}