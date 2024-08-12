package org.book.bookstore.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDto {
    private String title;
    private Double price;
    private Long authorId;
}
