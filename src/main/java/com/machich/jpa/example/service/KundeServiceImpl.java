package com.machich.jpa.example.service;


import com.machich.jpa.example.model.Auftrag;
import com.machich.jpa.example.model.Kunde;
import com.machich.jpa.example.repository.AuftragRepository;
import com.machich.jpa.example.repository.KundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KundeServiceImpl implements KundeService {


    KundeRepository kundenrepository;
    AuftragRepository auftragrepository;

    @Autowired
    public KundeServiceImpl(KundeRepository kundenrepository,AuftragRepository auftragrepository){
        this.kundenrepository=kundenrepository;
        this.auftragrepository=auftragrepository;
    }


    @Override
    public void saveKunde(Kunde kunde) {
        kundenrepository.save(kunde);
    }
}
