package com.inspireflow.quotegenerator.model;

public class Quote {
    private String content;
    private String author;

    // Constructors
    public Quote() {}

    public Quote(String content, String author) {
        this.content = content;
        this.author = author;
    }

    // Getters and Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}