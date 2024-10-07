package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Repository
public class StudentRepository implements IStudentRepository {

    @Value("${api.scope}")
    private String SCOPE;

    @Setter
    private String filePath;

    public StudentRepository() {
        this.filePath = "src/main/resources/users.json";
    }

    @Override
    public Set<StudentDTO> findAll() throws Exception{
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile(this.filePath);
            System.out.println("Loading file from: " + file.getAbsolutePath());
            loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("El archivo no se encontró en la ruta: " + filePath);
        } catch (IOException e) {
            throw new IOException("Error al procesar el archivo JSON: " + e.getMessage());
        }

        return loadedData;
    }
}
