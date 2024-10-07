package org.example.youtuberblog_ejercicio.service;

import org.example.youtuberblog_ejercicio.dto.CreateBlogDTO;
import org.example.youtuberblog_ejercicio.entities.EntradaBlog;
import org.example.youtuberblog_ejercicio.exceptions.BlogAlreadyExists;
import org.example.youtuberblog_ejercicio.exceptions.BlogDoesntExist;

import java.util.List;

public interface IBlogService {
    List<EntradaBlog> getAll();
    EntradaBlog createBlog(CreateBlogDTO dto) throws BlogAlreadyExists;
    EntradaBlog getEntradaBlog(Integer id) throws BlogDoesntExist;
}
