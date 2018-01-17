package com.practice.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.practice.demo.BookService.*;

/**
 * Created by cristina.manitiu on 1/12/2018.
 */
@RestController
public class BookController {

    @RequestMapping(value="/books", method= RequestMethod.GET)
    public List<Book> returnBookList(){
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
