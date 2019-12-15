package com.company.t6.dao;

import com.company.t6.entity.Book;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BookDao {

    public List<Book> getAll() throws IOException;

    public void add(Book book) throws FileNotFoundException;

    public void remove(Book book) throws FileNotFoundException, IOException;

}
