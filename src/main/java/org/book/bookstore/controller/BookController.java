package org.book.bookstore.controller;

import lombok.RequiredArgsConstructor;
import org.book.bookstore.dto.request.BookRequestDto;
import org.book.bookstore.dto.response.BookResponseDto;
import org.book.bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;



    @GetMapping("/all")
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("{id}")
    public BookResponseDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto book) {
        bookService.addBook(book);
        return "Book is created";
    }

    @DeleteMapping("/delete{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }


    @GetMapping("/author/{author}")
    public List<BookResponseDto> getBookByTitle(@PathVariable String author) {
        return bookService.getBookByAuthor(author);
    }
    @PutMapping("/update")
    public String updateBook(@RequestBody Long id, @RequestBody BookRequestDto book) {
        return bookService.updateBook(id,book);
    }
}