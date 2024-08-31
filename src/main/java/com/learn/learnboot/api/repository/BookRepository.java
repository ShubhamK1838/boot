package com.learn.learnboot.api.repository;


import com.learn.learnboot.api.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import java.util.List;


public interface BookRepository extends CrudRepository<Book,Integer> {

    public Book findByBid(int id );

    public List<Book> findByBookName(String bookName);


}
