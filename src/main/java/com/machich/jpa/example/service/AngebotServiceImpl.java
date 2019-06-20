package com.machich.jpa.example.service;

import com.machich.jpa.example.model.Angebot;
import com.machich.jpa.example.repository.AngebotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AngebotServiceImpl implements AngebotService {

    private AngebotRepository angebotRepository;

    @Autowired
    public AngebotServiceImpl(@Qualifier("angebotRepository") AngebotRepository angebotRepository){
        this.angebotRepository=angebotRepository;
    }
    @Override
    public void saveAngebot(Angebot angebot) {
        angebotRepository.save(angebot);
    }

    @Override
    public List<Angebot> getAll() {
        return angebotRepository.findAll();
    }

    @Override
    public Angebot getByID(int id) {
        return angebotRepository.findById(id);
    }

    @Override
    public void addAngebot(List<Angebot> angebotList, int id) {
        angebotList.add(angebotRepository.findById(id));
    }
}
