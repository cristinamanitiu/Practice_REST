package com.practice.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cristina.manitiu on 1/12/2018.
 */
@RestController
public class BookController {

    @RequestMapping("/books")
    public List<Book> returnBookList(){
        return BookService.getAllBooks();
    }
}
