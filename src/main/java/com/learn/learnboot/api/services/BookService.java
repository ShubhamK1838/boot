package com.learn.learnboot.api.services;

import com.learn.learnboot.api.entity.Book;
import com.learn.learnboot.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    @Autowired
    private BookRepository repo;

    public Book getBook(int id ){

        return repo.findByBid(id);
    }
    public List<Book> getBooks()
    {
        return (List<Book>) repo.findAll();
    }
    public List<Book> getBookByName(String name)
    {
       return  repo.findByBookName(name );
    }

    public Book  save(Book book )
    {
        return repo.save(book) ;
    }

    public void   remove(int id )
    {
        repo.deleteById(id );
    }

    public Book  update(Book book )
    {
        return repo.save(book);
    }
}
