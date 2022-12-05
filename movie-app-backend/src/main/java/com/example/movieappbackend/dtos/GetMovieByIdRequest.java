package com.example.movieappbackend.dtos;

public class GetMovieByIdRequest {
    private Long id;

    private GetMovieByIdRequest(GetMovieByIdRequestBuilder builder) {
        this.id = builder.id;
    }

    public Long getId() {
        return this.id;
    }

    public static class GetMovieByIdRequestBuilder {
        private Long id;

        public GetMovieByIdRequestBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public GetMovieByIdRequest build() {
            return new GetMovieByIdRequest(this);
        }
    }
}
