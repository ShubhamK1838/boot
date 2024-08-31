package com.learn.learnboot.api.controller;

import com.learn.learnboot.api.entity.Book;
import com.learn.learnboot.api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService service ;

    @GetMapping("/books")
   public java.util.List<Book>  getBooks()
   {
        return service.getBooks();
   }
   @GetMapping("/book{id}")
   public ResponseEntity<Book> getBook(@PathVariable("id") int id )
   {
       try{
           return  ResponseEntity.of(Optional.of(service.getBook(id )));

        }catch (Exception error)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
   }

   @PostMapping("/book")
   public ResponseEntity<Book> addBook(@RequestBody Book  book )
   {
       try {

           return  ResponseEntity.of(Optional.of(service.save( book)) );
       }catch (Exception error)
       {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
   }

   @DeleteMapping("/book{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable int id )
   {
       try {
           Book book = service.getBook(id);
            service.remove(id);
            return ResponseEntity.of(Optional.of(book));
       }catch (Exception error)
       {
           return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
   }

   @PutMapping("/book")
    public  ResponseEntity<Book>  update(@RequestBody Book book )
   {
        try {

            return  ResponseEntity.of(Optional.of(service.save(book)));
        }catch(Exception error )
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

   }
}
