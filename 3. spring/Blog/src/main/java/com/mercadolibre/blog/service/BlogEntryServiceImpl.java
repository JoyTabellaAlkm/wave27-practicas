package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.BlogEntryDTO;
import com.mercadolibre.blog.exceptions.AlreadyExistsException;
import com.mercadolibre.blog.exceptions.BlogEntryDoesNotExistsException;
import com.mercadolibre.blog.mapper.BlogEntryMapper;
import com.mercadolibre.blog.model.BlogEntry;
import com.mercadolibre.blog.repository.BlogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class BlogEntryServiceImpl implements IBlogEntryService{

    private final BlogEntryMapper blogEntryMapper;

    @Autowired
    public BlogEntryServiceImpl(BlogEntryMapper blogEntryMapper) {
        this.blogEntryMapper = blogEntryMapper;
    }

    @Override
    public String CreateBlogEntry(BlogEntryDTO blogEntryDTO) {

        BlogEntry blogEntry = blogEntryMapper.toBlogEntry(blogEntryDTO);

        boolean created = BlogEntryRepository.addEntradaBlog(blogEntry);

        if(created){
            return "Se creó correctamente con el id: " + blogEntryDTO.getId();
        }else{
            throw new AlreadyExistsException("Ya existe una entrada de blog con ese id");
        }

    }

    @Override
    public BlogEntryDTO getBlogEntry(int id) {
        BlogEntry blogEntry;
        blogEntry = BlogEntryRepository.getEntradaBlog(id);
        return blogEntryMapper.toBlogEntryDTO(blogEntry);
    }

    @Override
    public Set<BlogEntryDTO> getBlogEntrys() {
        Set<BlogEntryDTO> blogsEntryDTOS = blogEntryMapper.toBlogEntryDTOs(BlogEntryRepository.getEntradasBlog());
        return blogsEntryDTOS;
    }

}
