package com.company.t6.service;

import com.company.t6.entity.Book;
import com.company.t6.entity.BookQuery;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BookService {

    void printBooks() throws IOException;

    void add(Book book) throws FileNotFoundException;

    void remove(Book book) throws IOException;

    List<Book> findBook(BookQuery query) throws IOException;
}
