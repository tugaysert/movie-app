package com.example.movieappbackend.entity;

public class CreateReview {

    private String text;
    private Long movieId;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public CreateReview() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CreateReview(String text, Long movieId) {
        this.text = text;
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "text='" + text + '\'' +
                '}';
    }
}
