package com.company.t6.dao.impl;

import com.company.t6.dao.BookDao;
import com.company.t6.entity.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDaoImpl implements BookDao {

    public List<Book> getAll() throws IOException {
        Scanner in = new Scanner(new File("resources/sample.txt"));
        List<Book> books = new ArrayList<Book>();

        while (in.hasNext()) {
            Book book = new Book();
            String line = in.nextLine();
            if(line.isBlank()){
                continue;
            }
            String[] parts = line.split(", ");
            String author = parts[0];
            String name = parts[1];
            book.setAuthor(author);
            book.setName(name);
            books.add(book);
        }
        in.close();
        return books;
    }

    public void add(Book book) throws FileNotFoundException {

        try {
            FileWriter writer = new FileWriter("resources/sample.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write( '\n' + book.getAuthor() + ", " + book.getName());
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public void remove(Book book) throws FileNotFoundException, IOException {
        File sourceFile = new File("resources/sample.txt");
        File outputFile = new File("resources/sample1.txt");

        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        while ((line = reader.readLine()) != null) {
            if (!line.equals(book.toString())) {
                writer.write(line);
                writer.newLine();
            }
        }

        reader.close();
        writer.close();
        sourceFile.delete();
        outputFile.renameTo(sourceFile);
    }
}
