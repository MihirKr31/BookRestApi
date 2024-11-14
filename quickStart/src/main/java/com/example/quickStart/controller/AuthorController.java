package com.example.quickStart.controller;

import com.example.quickStart.models.Author;
import com.example.quickStart.services.AuthorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/authors")
public class AuthorController
{
    private final AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthor()
    {
        return authorService.getAllAuthor();
    }
    @PostMapping
    public Author createAuthor(@RequestBody Author author)
    {
        return authorService.createAuthor(author);
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable int id)
    {
        authorService.deleteAuthor(id);
        return "Successful Delete";
    }
    @PutMapping("/{id}")
    public String updateAuthor(@PathVariable int id,@RequestBody Author author)
    {
        authorService.updateAuthor(id,author);
        return "Update Successful";
    }
}
