package com.practice.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by cristina.manitiu on 1/12/2018.
 */
public class BookService {
    private static final AtomicLong counter = new AtomicLong();

    private static List<Book> bookList;

    static {
        bookList = setDefaultBooks();
    }

    public static List<Book> getAllBooks(){
        return bookList;
    }

    public void addBook(Book b){
        b.setId(counter.incrementAndGet());
        bookList.add(b);
    }

    private static List<Book> setDefaultBooks(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(counter.incrementAndGet(),"Book1","Auth1"));
        bookList.add(new Book(counter.incrementAndGet(),"Book2","Auth2"));
        bookList.add(new Book(counter.incrementAndGet(),"Book3","Auth3"));
        return bookList;
    }
}
