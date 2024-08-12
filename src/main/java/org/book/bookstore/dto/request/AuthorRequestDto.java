package org.book.bookstore.dto.request;

import lombok.Data;

@Data
public class AuthorRequestDto {
    private String name;
    private String surname;
    private Integer age;
}
