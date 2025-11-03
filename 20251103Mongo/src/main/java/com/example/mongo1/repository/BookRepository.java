package com.example.mongo1.repository;

import com.example.mongo1.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}

