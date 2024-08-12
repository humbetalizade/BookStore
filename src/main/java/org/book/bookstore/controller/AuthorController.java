package org.book.bookstore.controller;


import lombok.RequiredArgsConstructor;
import org.book.bookstore.dto.request.AuthorRequestDto;
import org.book.bookstore.dto.response.AuthorResponseDto;
import org.book.bookstore.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    @GetMapping("/getAll")
    public List<AuthorResponseDto> getAllAuthors() {
        return authorService.getAll();

    }

    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorRequestDto bookDto) {
        authorService.addAuthor(bookDto);
        return "success";
    }
}
