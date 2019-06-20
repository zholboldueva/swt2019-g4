package com.machich.jpa.example.service;

import com.machich.jpa.example.model.Auftrag;
import com.machich.jpa.example.repository.AuftragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuftragServiceImpl implements AuftragService {


     AuftragRepository auftragRepository ;

    @Autowired
    public AuftragServiceImpl(@Qualifier("auftragRepository") AuftragRepository auftragRepository){
        this.auftragRepository=auftragRepository;
    }

    @Override
    public void saveAuftrag(Auftrag auftrag) {
        auftragRepository.save(auftrag);
    }

    @Override
    public List<Auftrag> getAll() {
        return auftragRepository.findAll();
    }

    @Override
    public Auftrag getByID(int id) {
        return auftragRepository.findById(id);
    }

    @Override
    public void addAuftrag(List<Auftrag> auftragList, int id) {
        auftragList.add(auftragRepository.findById(id));
    }


}
