package com.example.movieappbackend.entity;

public class Review {

    private String text;

    public Review() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Review(String text) {
        this.text = text;

    }

    @Override
    public String toString() {
        return "Review{" +
                "text='" + text + '\'' +
                '}';
    }
}
