package com.example.calcularedad.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public interface IAgeService {

    int calculateAge(int day, int month, int year);

}
