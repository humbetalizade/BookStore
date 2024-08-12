package org.book.bookstore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.book.bookstore.dto.request.AuthorRequestDto;
import org.book.bookstore.dto.response.AuthorResponseDto;
import org.book.bookstore.entity.Author;
import org.book.bookstore.entity.Book;
import org.book.bookstore.repository.AuthorRepository;
import org.book.bookstore.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final ModelMapper mapper;

    public void addAuthor(AuthorRequestDto authorRequestDto){
        log.info(authorRequestDto.toString());
        Author author = mapper.map(authorRequestDto, Author.class);
        log.info(author.toString());
        authorRepository.save(author);
    }



    public List<AuthorResponseDto> getAll(){
        List<Author> books = authorRepository.findAll();
        return books.stream().map(item -> mapper.map(item, AuthorResponseDto.class)).toList();
    }


}
