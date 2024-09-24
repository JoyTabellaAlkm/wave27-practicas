package com.w27.exceptionslibros.service;

import com.w27.exceptionslibros.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book findById(long id);
}
