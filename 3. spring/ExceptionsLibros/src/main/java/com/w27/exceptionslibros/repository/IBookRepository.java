package com.w27.exceptionslibros.repository;

import com.w27.exceptionslibros.model.Book;

import javax.swing.plaf.SpinnerUI;
import java.util.List;

public interface IBookRepository {
    public List<Book> getAll();
    public Book findById(Long id);
}
