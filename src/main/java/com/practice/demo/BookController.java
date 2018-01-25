package com.practice.demo;

import org.springframework.web.bind.annotation.*;
import sun.plugin.com.event.COMEventHandler;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.lang.String;

import static com.practice.demo.BookService.getAllBooks;

/**
 * Created by cristina.manitiu on 1/12/2018.
 */
@RestController
public class BookController {

    @RequestMapping(value="/books", method= RequestMethod.GET)
    public List<Book> returnBookList(){
        CompletableFuture<String> cf1 = BookService.getPromise(1);
        CompletableFuture<String> cf2 = BookService.getPromise(2);

      //  CompletableFuture<String> combined = cf1.thenCombine(cf2, (a,b) -> "first : " + a + " second : " + b);
     //   String finalValue = combined.join();
        cf2.acceptEither(cf1, s -> {
            System.out.println("Result = " + s);});
        //System.out.println("Our value is = " +  finalValue);

        return getAllBooks();
    }

    @RequestMapping(value="/books",method=RequestMethod.POST)
    public void addBook(@RequestBody Book book){
        BookService.addBook(book);
    }

    @RequestMapping (value="/books/{id}", method=RequestMethod.DELETE)
    public void deleteBook(@PathVariable ("id") long id){
        BookService.deleteBook(id);
    }

    @RequestMapping (value="/books/{id}", method=RequestMethod.PUT)
    public void editBook(@PathVariable ("id") long id, @RequestParam (value="author") String auth,
                         @RequestParam (value="title") String titl){
        System.out.println("edit Book function");
        BookService.updateBook(id,auth,titl);
    }
}
