package com.company.t6.service.impl;

import com.company.t6.dao.BookDao;
import com.company.t6.entity.Book;
import com.company.t6.entity.BookQuery;
import com.company.t6.service.BookService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookService {

    private BookDao dao;

    public BookServiceImpl(BookDao dao) {
        this.dao = dao;
    }

    public void printBooks() throws IOException {
        for (Book book:
                dao.getAll()) {
            System.out.println(book);
        }
    }

    public void add(Book book) throws FileNotFoundException {
        dao.add(book);
    }

    public void remove(Book book) throws IOException {
        dao.remove(book);
    }

    public List<Book> findBook(BookQuery query) throws IOException {
        List<Book> books = dao.getAll();
        if(query.getAuthor() == null && query.getName() == null){
            return books;
        }
        List<Book> newBooks = new ArrayList<Book>();
        for (Book book: books) {
            if(query.getAuthor() != null && query.getName() != null) {
                if (query.getName().trim().equalsIgnoreCase(book.getName().trim()) && query.getAuthor().equalsIgnoreCase(book.getAuthor().trim())) {
                    newBooks.add(book);
                }
                continue;
            }
            if(query.getName() != null){
                if(query.getName().trim().equalsIgnoreCase(book.getName().trim())){
                    newBooks.add(book);
                }
                continue;
            }
            if(query.getAuthor() != null){
                if(query.getAuthor().trim().equalsIgnoreCase(book.getAuthor().trim())){
                    newBooks.add(book);
                }
            }
        }
        return newBooks;
    }
}
