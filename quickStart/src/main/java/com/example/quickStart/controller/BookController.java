package com.example.quickStart.controller;



import com.example.quickStart.models.Book;
import com.example.quickStart.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController
{
    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBook()
    {
        return bookService.getAllBooks();
    }
    @PostMapping("/user/{id}")
    public Book createBook(@RequestBody Book book,@PathVariable int id)
    {

        return bookService.createBook(book,id);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id)
    {
        bookService.deleteBook(id);
        return "Successful Delete";
    }
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id,@RequestBody Book book)
    {
        bookService.updateBook(id,book);
        return "Update Successful";
    }
}
