package com.example.quickStart.models;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Author
{
    @Id
    @GeneratedValue
    private int id;
    @Column(
            name =  "f_name",
            length = 35
    )
    private String firstName;
    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    private int age;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> books;


}
