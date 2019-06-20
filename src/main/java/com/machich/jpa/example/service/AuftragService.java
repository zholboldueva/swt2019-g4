package com.machich.jpa.example.service;

import com.machich.jpa.example.model.Auftrag;


import java.util.List;

public interface AuftragService {

    void saveAuftrag(Auftrag auftrag);

    List<Auftrag> getAll();

    Auftrag getByID(int id);

    void addAuftrag(List<Auftrag> auftragList, int id);


}
