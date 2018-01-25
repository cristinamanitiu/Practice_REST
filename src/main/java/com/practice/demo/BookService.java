package com.practice.demo;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by cristina.manitiu on 1/12/2018.
 */
public class BookService {
    private static final AtomicLong counter = new AtomicLong();

    private static List<Book> bookList;
    private static ExecutorService executor = Executors.newFixedThreadPool(10);

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

    public static CompletableFuture<String> getPromise(long id){
        CompletableFuture<String> cf = new CompletableFuture<>();
        executor.submit(() -> {
            try{
                cf.complete(getBookNameById(id));
            }catch(NullPointerException e){
                cf.completeExceptionally(e);
            }
        });
        return cf;
    }

    public static String getBookNameById(long id) throws NullPointerException{
        Iterator<Book> it = bookList.iterator();
        while(it.hasNext()){
            Book b = it.next();
            if (b.getId() == id){
                return b.getTitle();
            }
        }
        return "Not found";
    }

    private static List<Book> setDefaultBooks(){
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(counter.incrementAndGet(),"Book1","Auth1"));
        bookList.add(new Book(counter.incrementAndGet(),"Book2","Auth2"));
        bookList.add(new Book(counter.incrementAndGet(),"Book3","Auth3"));
        return bookList;
    }

}
