package com.machich.jpa.example.repository;

import com.machich.jpa.example.model.Angebot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="angebotRepository")
public interface AngebotRepository extends JpaRepository<Angebot, Integer> {

    Angebot findById(int id);
}
