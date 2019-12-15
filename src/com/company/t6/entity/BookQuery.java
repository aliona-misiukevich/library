package com.company.t6.entity;

public final class BookQuery {
    private String author;
    private String name;

    public BookQuery(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }
}
