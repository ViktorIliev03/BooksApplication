package com.example.booksapplication.service;

import com.example.booksapplication.model.entity.AuthorEntity;
import com.example.booksapplication.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<AuthorEntity> findAuthorByName(String name) {
        return this.authorRepository.findByName(name);
    }

    public AuthorEntity save(AuthorEntity newAuthor) {
        return this.authorRepository.save(newAuthor);
    }
}
