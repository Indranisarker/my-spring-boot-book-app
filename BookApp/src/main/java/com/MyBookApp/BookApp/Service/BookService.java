package com.MyBookApp.BookApp.Service;


import com.MyBookApp.BookApp.Domains.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    List<Book> bookList = new ArrayList<>();
    Integer id = 0;

    public Book addBook(Book book){
        book.setBookId(++id);
        bookList.add(book);
        return book;
    }

    public List<Book> getBookList(){
        return bookList;
    }
    public Book getBook(Integer id){
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getBookId().equals(id)){
                return bookList.get(i);
            }
        }
        return null;
    }
    public Book updateBook(Integer id, Book book){
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getBookId().equals(id)){
                book.setBookId(id);
                bookList.set(i, book);
                break;
            }
        }
        return book;
    }
    public void deleteBook(Integer id){
        bookList.removeIf(book -> Objects.equals(book.getBookId(), id));
        System.out.printf("Delete Successfully!");
    }
}
