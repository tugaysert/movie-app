package com.example.movieappbackend.entity;

public class Detail {

    private String text;

    public Detail() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Detail(String text) {
        this.text = text;

    }

    @Override
    public String toString() {
        return "Detail{" +
                "text='" + text + '\'' +
                '}';
    }
}
