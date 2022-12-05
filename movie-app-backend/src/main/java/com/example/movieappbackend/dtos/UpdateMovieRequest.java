package com.example.movieappbackend.dtos;

public class UpdateMovieRequest {
    private String title;
    private String director;
    private String writer;
    private String star;
    private String genre;
    private int year;

    private UpdateMovieRequest(UpdateMovieRequestBuilder builder) {
        this.title = builder.title;
        this.director = builder.director;
        this.writer = builder.writer;
        this.star = builder.star;
        this.genre = builder.genre;
        this.year = builder.year;
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

    public static class UpdateMovieRequestBuilder {
        private String title;
        private String director;
        private String writer;
        private String star;
        private String genre;
        private int year;

        public UpdateMovieRequestBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateMovieRequestBuilder setDirector(String director) {
            this.director = director;
            return this;
        }

        public UpdateMovieRequestBuilder setWriter(String writer) {
            this.writer = writer;
            return this;
        }

        public UpdateMovieRequestBuilder setStar(String star) {
            this.star = star;
            return this;
        }

        public UpdateMovieRequestBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public UpdateMovieRequestBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public UpdateMovieRequest build() {
            return new UpdateMovieRequest(this);
        }
    }

}