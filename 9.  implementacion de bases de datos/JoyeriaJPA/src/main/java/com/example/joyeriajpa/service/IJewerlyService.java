package com.example.joyeriajpa.service;

import com.example.joyeriajpa.model.Jewel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IJewerlyService {
    public List<Jewel> getJewels();

    public void saveJewel(Jewel jewel);

    @Transactional
    Jewel updateJewel(int id, Jewel updatedJewel);

    public void deleteJewel(int id);

    public Jewel findJewel(int id);
}
