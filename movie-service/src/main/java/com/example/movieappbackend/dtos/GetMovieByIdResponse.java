package com.example.movieappbackend.dtos;

import com.example.movieappbackend.entity.Movie;

public class GetMovieByIdResponse {
    private Movie movie;

    private GetMovieByIdResponse(GetMovieByIdResponseBuilder builder) {
        this.movie = builder.movie;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public static class GetMovieByIdResponseBuilder {
        private Movie movie;

        public GetMovieByIdResponseBuilder setMovie(Movie movie) {
            this.movie = movie;
            return this;
        }

        public GetMovieByIdResponse build() {
            return new GetMovieByIdResponse(this);
        }
    }
}

