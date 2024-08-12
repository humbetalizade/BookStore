package org.book.bookstore.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.book.bookstore.dto.request.AuthorRequestDto;
import org.book.bookstore.entity.Author;

@Setter
@Getter
public class BookResponseDto {
    private Long id;
    private String title;
    private Double price;
    @JsonBackReference
    private AuthorResponseDto author;
}
