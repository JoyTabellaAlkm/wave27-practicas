package ar.com.covid.covid19.controller;

import ar.com.covid.covid19.entity.Sintoma;
import ar.com.covid.covid19.entity.dto.PersonaDTO;
import ar.com.covid.covid19.service.imp.DetectorDeCovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/symptom")
public class SintomasController {

    @Autowired
    private DetectorDeCovidService detectorDeCovidService;

    @GetMapping("/findSymptom")
    @ResponseBody
    public List<Sintoma> findSymptom(){
        return detectorDeCovidService.findAllSymptom();
    }

    @GetMapping("/findSymptom/{name}")
    ResponseEntity<String> findSymptom(@PathVariable String name){
        return detectorDeCovidService.findSymptom(name);
    }

    @GetMapping("/findRiskPerson")
    @ResponseBody
    public List<PersonaDTO> findRiskPerson(){
        return detectorDeCovidService.findRiskPerson();
    }
}
