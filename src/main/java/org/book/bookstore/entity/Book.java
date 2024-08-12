package org.book.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_price")
    private Double price;


    @ManyToOne ()
    @JsonIgnore
    @JoinColumn(name = "author_book")
    private Author author;





}
