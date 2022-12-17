package com.example.detailservice.model;


import jakarta.persistence.Column;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import jakarta.persistence.*;



public class CreateDetail {


    private Long movieId;


    @Override
    public String toString() {
        return "Detail{" +
                ", movieId=" + movieId +
                ", text='" + text + '\'' +
                '}';
    }

    public CreateDetail() {
    }

    private String text;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CreateDetail(Long movieId, String text) {
        this.movieId = movieId;
        this.text = text;
    }
}
