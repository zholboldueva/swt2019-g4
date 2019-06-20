package com.machich.jpa.example.service;

import com.machich.jpa.example.model.Angebot;

import java.util.List;

public interface AngebotService {

    void saveAngebot(Angebot angebot);

    List<Angebot> getAll();

    Angebot getByID(int id);

    void addAngebot(List<Angebot> angebotList, int id);


}
