package com.practice.demo;

/**
 * Created by cristina.manitiu on 1/12/2018.
 */

public class Book {
    private long id;
    private String title;
    private String author;

    public Book(){

    }

    public Book(long id,String title, String author){
        System.out.println("Constructor with params");
        this.id=id;
        this.title=title;
        this.author=author;
    }


    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public void setId(long id){
        this.id=id;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setAuthor(String author){
        this.author=author;
    }
}
