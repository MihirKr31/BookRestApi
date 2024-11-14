package com.example.quickStart.services;
import java.time.LocalDateTime;
import java.util.*;

import com.example.quickStart.models.Author;
import com.example.quickStart.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService
{
    private final AuthorRepository authorRepository;
    public List<Author> getAllAuthor()
    {
        return authorRepository.findAll();
    }
    public Author createAuthor(Author author)
    {

        return authorRepository.save(author);
    }

    public void deleteAuthor(int id)
    {
         authorRepository.deleteById(id);

    }
    public Author updateAuthor(int id,Author author){
        Author author1 = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        author1.setFirstName(author.getFirstName());
        author1.setAge(author.getAge());
        author1.setLastName(author.getLastName());
        author1.setEmail(author.getEmail());

        return authorRepository.save(author1);
    }

}
