package com.w27.exceptionslibros.repository;

import com.w27.exceptionslibros.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository implements IBookRepository {
    List<Book> books = List.of(
            new Book(1L, "Book 1", "Author 1"),
            new Book(2L, "Book 2", "Author 2"),
            new Book(3L, "Book 3", "Author 3")
    );

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Book findById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }
}
