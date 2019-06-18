package com.machich.jpa.example.service;

import com.machich.jpa.example.model.Auftrag;


import java.util.List;

public interface AuftragService {

    Auftrag addAuftrag(Auftrag auftrag);

    List<Auftrag> getAll();

    Auftrag getByID(int id);

}
