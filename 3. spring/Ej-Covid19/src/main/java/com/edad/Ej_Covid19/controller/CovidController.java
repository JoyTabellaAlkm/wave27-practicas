package com.edad.Ej_Covid19.controller;

import com.edad.Ej_Covid19.modelo.Sintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edad.Ej_Covid19.service.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/covid19/")
public class CovidController {

    @Autowired
    ISintomasFinder sintomasFinder;

    @GetMapping("/findSymptom")
    public ResponseEntity<?> showAllSymptoms() {
        if( sintomasFinder.showAllSymptoms() ==null){
            return new ResponseEntity<>("La lista consultada está vacía",HttpStatus.OK);
        }
        return new ResponseEntity<List<Sintoma>>( sintomasFinder.showAllSymptoms() , HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> showSymptom(@PathVariable String name){
        if (sintomasFinder.checkSymptom(name) == null){
            return new ResponseEntity<>("El sintoma no existe", HttpStatus.OK);
        }
        return new ResponseEntity<>( sintomasFinder.checkSymptom(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> getRiskPerson() {
        if (sintomasFinder.getRiskPerson()==null){
            return new ResponseEntity<>("No hay personas en riesgo", HttpStatus.OK);
        }
        return new ResponseEntity<>( sintomasFinder.getRiskPerson(), HttpStatus.OK);
    }

}
