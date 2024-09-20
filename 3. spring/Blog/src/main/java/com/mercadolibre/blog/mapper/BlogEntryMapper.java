package com.mercadolibre.blog.mapper;

import com.mercadolibre.blog.dto.BlogEntryDTO;
import com.mercadolibre.blog.model.BlogEntry;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface BlogEntryMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "titulo"),
            @Mapping(source = "authorName", target = "nombreAutor"),
            @Mapping(source = "date", target = "fechaPublicacion", dateFormat = "dd/MM/yyyy")
    })
    BlogEntry toBlogEntry(BlogEntryDTO blogEntryDTO);

    @InheritInverseConfiguration
    BlogEntryDTO toBlogEntryDTO(BlogEntry blogEntry);

    Set<BlogEntry> toBlogEntrys(Set<BlogEntryDTO> blogEntryDTOList);

    Set<BlogEntryDTO> toBlogEntryDTOs(Set<BlogEntry> blogEntryList);

}
