package com.w27.exceptionslibros.controller;

import com.w27.exceptionslibros.exceptions.NotFoundException;
import com.w27.exceptionslibros.model.Book;
import com.w27.exceptionslibros.repository.IBookRepository;
import com.w27.exceptionslibros.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {
    @Autowired
    IBookService iBookService;

    @RequestMapping("/libros")
    ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iBookService.getAll());
    }

    @RequestMapping("/libros/{id}")
    ResponseEntity<?> findById(@PathVariable long id){
        Book bookFound = iBookService.findById(id);
        if (bookFound == null){
            throw new NotFoundException("El libro con el id: " + id + " no fue encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookFound);
    }
}
