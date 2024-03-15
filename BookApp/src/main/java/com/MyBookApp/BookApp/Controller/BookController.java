package com.MyBookApp.BookApp.Controller;


import com.MyBookApp.BookApp.Domains.Book;
import com.MyBookApp.BookApp.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
@Autowired
BookService bookService;

    // add books in booklist
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
       bookService.addBook(book);
        return book;
    }

    //get one book by id
    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") Integer id){
       return bookService.getBook(id);
    }
    //get all books
    @GetMapping("/")
    public List<Book> getAllBooks(){
        return bookService.getBookList();
    }
    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable("id") Integer id, @RequestBody Book book){
        return bookService.updateBook(id,book);
    }
    @DeleteMapping("/delete")
    public void deleteBook(@RequestParam("id") Integer id){
       bookService.deleteBook(id);
    }

}
