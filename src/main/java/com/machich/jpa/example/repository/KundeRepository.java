package com.machich.jpa.example.repository;

import com.machich.jpa.example.model.Auftrag;
import com.machich.jpa.example.model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="kundeRepository")
public interface KundeRepository extends JpaRepository<Kunde, Integer> {

//       Kunde addKundebyAuftragID(int id);
//       Kunde findByAuftrag(Auftrag auftrag);
}
