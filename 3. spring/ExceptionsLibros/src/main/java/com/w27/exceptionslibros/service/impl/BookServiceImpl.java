package com.w27.exceptionslibros.service.impl;

import com.w27.exceptionslibros.model.Book;
import com.w27.exceptionslibros.repository.IBookRepository;
import com.w27.exceptionslibros.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id);
    }
}
