package com.company.t6.main;

import com.company.t6.dao.BookDao;
import com.company.t6.dao.impl.BookDaoImpl;
import com.company.t6.entity.Book;
import com.company.t6.entity.BookQuery;
import com.company.t6.service.BookService;
import com.company.t6.service.impl.BookServiceImpl;


import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        BookDao bookDao = new BookDaoImpl();
        BookService bookService = new BookServiceImpl(bookDao);
        //BookSet bookSet = new BookSet();

       // bookSet.setBooks(bookDao.getAllBooks());
        bookService.printBooks();

        Book book1 = new Book();
        book1.setName("Drive");
        book1.setAuthor("Daniele Pink");

        //bookService.add(book1);
        //bookService.remove(book1);
        //bookService.printBooks();

        BookQuery query = new BookQuery("helen rassel", "Hugge");
    }
}
