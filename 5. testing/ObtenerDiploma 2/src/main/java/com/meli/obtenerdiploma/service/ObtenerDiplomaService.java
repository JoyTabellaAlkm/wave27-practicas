package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    @Autowired
    IStudentDAO studentDAO;

    @Override
    public StudentDTO analyzeScores(Long studentId) {
        StudentDTO stu = studentDAO.findById(studentId);

        stu.setAverageScore(calculateAverage(stu.getSubjects()));
        stu.setMessage(getGreetingMessage(stu.getStudentName(), stu.getAverageScore()));

        return stu;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    public Double calculateAverage(List<SubjectDTO> scores) {
        scores.forEach(subject -> System.out.println("Subject: " + subject.getName() + ", Score: " + subject.getScore()));
        return scores.stream()
                .mapToDouble(SubjectDTO::getScore).sum() / scores.size();
    }
}
