package com.bootcamp.pruebaspring.romanNumber;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roman")
public class RomanNumberController {

    @Autowired
    IRomanNumber romanNumber;


    @GetMapping("/{number}")
    public ResponseEntity<String> convertToRomanNumber(@PathVariable Integer number){
        if (number > 3999) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El número no debe ser mayor que 4000");
        }

        String response = romanNumber.decimalToRoman(number);
        return ResponseEntity.ok(response);
    }
}
