package com.example.MiniSeries.service;

import com.example.MiniSeries.repository.IMiniSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {
    @Autowired
    IMiniSerieRepository iminiSerieRepository;
}
