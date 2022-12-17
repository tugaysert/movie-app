package com.example.movieappbackend.dtos;

import com.example.movieappbackend.entity.Detail;
import com.example.movieappbackend.entity.Detail;

public class CreateMovieRequest {
    private String title;
    private String director;
    private String writer;
    private String star;
    private String genre;
    private int year;

    private Detail detail;

    public CreateMovieRequest() {
    }

    private CreateMovieRequest(CreateMovieRequestBuilder builder) {
        this.title = builder.title;
        this.director = builder.director;
        this.writer = builder.writer;
        this.star = builder.star;
        this.genre = builder.genre;
        this.year = builder.year;
        this.detail = builder.detail;
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

    public Detail getDetail() {
        return this.detail;
    }
    public static class CreateMovieRequestBuilder {
        private String title;
        private String director;
        private String writer;
        private String star;
        private String genre;
        private int year;

        private Detail detail;

        public CreateMovieRequestBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateMovieRequestBuilder setDirector(String director) {
            this.director = director;
            return this;
        }

        public CreateMovieRequestBuilder setWriter(String writer) {
            this.writer = writer;
            return this;
        }

        public CreateMovieRequestBuilder setStar(String star) {
            this.star = star;
            return this;
        }

        public CreateMovieRequestBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public CreateMovieRequestBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public CreateMovieRequestBuilder setDetail(Detail detail) {
            this.detail = detail;
            return this;
        }

        public CreateMovieRequest build() {
            return new CreateMovieRequest(this);
        }
    }
}
