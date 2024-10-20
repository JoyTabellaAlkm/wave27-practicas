package com.example.joyeriajpa.service.impl;

import com.example.joyeriajpa.exception.NotFoundException;
import com.example.joyeriajpa.model.Jewel;
import com.example.joyeriajpa.repository.IJewerlyRepository;
import com.example.joyeriajpa.service.IJewerlyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JewerlyServiceImpl implements IJewerlyService {

    private final IJewerlyRepository jewerlyRepository;

    public JewerlyServiceImpl(IJewerlyRepository jewerlyRepository) {
        this.jewerlyRepository = jewerlyRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jewel> getJewels() {

        List<Jewel> jewels = jewerlyRepository.findAll();
        return jewels.stream()
                .filter(Jewel::isSaleOrNot)
                .toList();
    }

    @Transactional
    @Override
    public void saveJewel(Jewel jewel) {
        jewel.setSaleOrNot(true);
        jewerlyRepository.save(jewel);
    }

    @Transactional
    @Override
    public Jewel updateJewel(int id, Jewel updatedJewel) {
        return jewerlyRepository.findById(id)
                .map(jewel -> {
                                jewel.setName(updatedJewel.getName());
                                jewel.setMaterial(updatedJewel.getMaterial());
                                jewel.setWeight(updatedJewel.getWeight());
                                jewel.setDescription(updatedJewel.getDescription());
                                jewel.setHasStone(updatedJewel.isHasStone());
                                return jewerlyRepository.save(jewel);})
                .orElseThrow(() -> new NotFoundException("Jewel with ID " + id + " not found."));

    }

    @Override
    public void deleteJewel(int id) {
        jewerlyRepository.findById(id).ifPresentOrElse(jewel -> {
            jewel.setSaleOrNot(false);
            jewerlyRepository.save(jewel);
        }, () -> {
            throw new NotFoundException("Joya con el id " + id + " no encontrado.");
        });

    }

    @Transactional(readOnly = true)
    @Override
    public Jewel findJewel(int id) {
        Jewel jewel = jewerlyRepository.findById(id).orElse(null);
        return jewel;
    }

}
