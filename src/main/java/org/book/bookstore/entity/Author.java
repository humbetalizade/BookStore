package org.book.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Table(name = "author")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "author")
    private List<Book> books;
}