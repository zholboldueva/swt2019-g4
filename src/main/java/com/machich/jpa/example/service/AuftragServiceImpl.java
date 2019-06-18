package com.machich.jpa.example.service;

import com.machich.jpa.example.model.Auftrag;
import com.machich.jpa.example.repository.AuftragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuftragServiceImpl implements AuftragService {

    @Qualifier("auftragRepository")
    @Autowired
    private AuftragRepository auftragRepository;

    @Override
    public Auftrag addAuftrag(Auftrag auftrag) {
        Auftrag saveAuftrag = auftragRepository.saveAndFlush(auftrag);

        return saveAuftrag;
    }

    @Override
    public List<Auftrag> getAll() {
        return auftragRepository.findAll();
    }

    @Override
    public Auftrag getByID(int id) {
        return auftragRepository.findById(id);
    }


}
