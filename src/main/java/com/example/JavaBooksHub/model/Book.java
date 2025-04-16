package com.example.JavaBooksHub.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String bookName;
    private Date bookDate;
    private int ratingBook;
}
