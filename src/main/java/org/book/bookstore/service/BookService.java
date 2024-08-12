package org.book.bookstore.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.book.bookstore.dto.request.BookRequestDto;
import org.book.bookstore.dto.response.BookResponseDto;
import org.book.bookstore.entity.Author;
import org.book.bookstore.entity.Book;
import org.book.bookstore.repository.AuthorRepository;
import org.book.bookstore.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final ModelMapper mapper;
    private final AuthorRepository authorRepository;



    //this method adds a new book to the list
    public void addBook(BookRequestDto bookDto) {
        Book book = mapper.map(bookDto, Book.class);
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElseThrow();
        book.setAuthor(author);
        bookRepository.save(book);
    }





    //this method returns us all books
    public List<BookResponseDto> getAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(item -> mapper.map(item, BookResponseDto.class)).toList();
    }





    // this method can find the book with its id
    public BookResponseDto getBookById(Long id) {
        return mapper.map(bookRepository.findById(id).get(), BookResponseDto.class);
    }


    //this method can delete the book with its id
    public String deleteBookById(Long id) {
        bookRepository.deleteById(id);
        return "Book deleted";
    }


    //this method can find the book with its Author name
    public List<BookResponseDto> getBookByAuthor(String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            if (book.getAuthor().equals(author)) {
                authorBooks.add(book);
            }
        }
        return authorBooks.stream().map(item -> mapper.map(item, BookResponseDto.class)).toList();
    }

    public String updateBook(Long id, BookRequestDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow();
        mapper.map(bookDto, book);
        bookRepository.save(book);
        return "book update successfully";

    }
}
