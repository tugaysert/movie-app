package com.example.reviewservice.model;


import jakarta.persistence.Column;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import jakarta.persistence.*;


@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "_movie_id")
    @NotNull
    @Size(min = 1, max = 100)
    private Long movieId;


    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", text='" + text + '\'' +
                '}';
    }

    @Column(name = "_text")
    @NotNull
    @Size(min = 1, max = 100)
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Review(Long id, Long movieId, String text) {
        this.id = id;
        this.movieId = movieId;
        this.text = text;
    }
}
