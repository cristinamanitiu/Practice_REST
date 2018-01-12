package com.practice.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cristina.manitiu on 1/12/2018.
 */
@RestController
public class BookController {

    @RequestMapping(value="/books", method= RequestMethod.GET)
    public List<Book> returnBookList(){
        return BookService.getAllBooks();
    }

    @RequestMapping(value="/books",method=RequestMethod.POST)
    public void addBook(@RequestBody Book book){
        BookService.addBook(book);
    }
}
