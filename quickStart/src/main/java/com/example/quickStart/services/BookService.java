package com.example.quickStart.services;

import com.example.quickStart.models.Author;
import com.example.quickStart.models.Book;

import com.example.quickStart.models.Book;
import com.example.quickStart.repositories.AuthorRepository;
import com.example.quickStart.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService
{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }
    public Book createBook(Book book,int author_id)
    {
        Author a1 = authorRepository.findById(author_id).orElseThrow(() -> new RuntimeException("Author not found"));
        book.setAuthor(a1);
        return bookRepository.save(book);
    }

    public void deleteBook(int id)
    {
        bookRepository.deleteById(id);

    }
    public Book updateBook(int id,Book book){
        Book book1 = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        book1.setBookName(book.getBookName());
        book1.setAuthor(book.getAuthor());
        return bookRepository.save(book1);
    }


}
