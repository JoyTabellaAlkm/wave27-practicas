package org.example.youtuberblog_ejercicio.repository;

import org.example.youtuberblog_ejercicio.dto.CreateBlogDTO;
import org.example.youtuberblog_ejercicio.entities.EntradaBlog;
import org.example.youtuberblog_ejercicio.exceptions.BlogAlreadyExists;
import org.example.youtuberblog_ejercicio.exceptions.BlogDoesntExist;

import java.util.List;

public interface IBlogRepository {
    List<EntradaBlog> getAll();
    EntradaBlog createBlog(CreateBlogDTO dto) throws BlogAlreadyExists;
    EntradaBlog getEntradaBlog(Integer id) throws BlogDoesntExist;
}
