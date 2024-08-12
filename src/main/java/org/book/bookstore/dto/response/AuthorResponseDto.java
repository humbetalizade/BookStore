package org.book.bookstore.dto.response;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.book.bookstore.entity.Book;

import java.util.List;

@Data
@Getter
@Setter
public class AuthorResponseDto {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    @JsonManagedReference
    private List<BookResponseDto> books;
}
