package com.machich.jpa.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Kompetenz")
public class Kompetenz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Kompetenz_ID")
    private int id;
    @Column(name = "Beschreibung")
    private String beschreibung;
}
