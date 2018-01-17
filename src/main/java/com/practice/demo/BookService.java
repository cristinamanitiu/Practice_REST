package com.practice.demo;

import java.util.ArrayList;
import java.util.Iterator;
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

    public static void addBook(Book b){
        b.setId(counter.incrementAndGet());
        bookList.add(b);
    }

    public static void deleteBook(long id){
        Iterator<Book> it = bookList.iterator();
        while(it.hasNext()){
            Book b = it.next();
            if(b.getId() == id){
                it.remove();
            }
        }
    }

    public static void updateBook(long id, String auth, String titl){
        Iterator<Book> it = bookList.iterator();
        while(it.hasNext()){
            Book b = it.next();
            if(b.getId() == id){
                if(auth != null)
                    b.setAuthor(auth);
                if(titl != null)
                    b.setTitle(titl);
            }
        }
    }

    private static List<Book> setDefaultBooks(){
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(counter.incrementAndGet(),"Book1","Auth1"));
        bookList.add(new Book(counter.incrementAndGet(),"Book2","Auth2"));
        bookList.add(new Book(counter.incrementAndGet(),"Book3","Auth3"));
        return bookList;
    }

}
