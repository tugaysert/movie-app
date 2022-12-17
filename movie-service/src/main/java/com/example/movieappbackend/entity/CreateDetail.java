package com.example.movieappbackend.entity;

public class CreateDetail {

    private String text;
    private Long movieId;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public CreateDetail() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CreateDetail(String text, Long movieId) {
        this.text = text;
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "text='" + text + '\'' +
                '}';
    }
}
