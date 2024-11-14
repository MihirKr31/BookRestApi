package com.example.quickStart.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Book
{

    private String bookName;

    @Id
    @GeneratedValue
    private int bookId;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

}
