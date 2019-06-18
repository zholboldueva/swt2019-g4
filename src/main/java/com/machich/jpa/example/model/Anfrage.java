package com.machich.jpa.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUFTRAG")
public class Anfrage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AUFTRAG_ID")
    private int id;
    @Column(name = "KATEGORY")
    private Category Kategory;
    @Column(name = "TITEL")
    private String titel;
    @Column(name = "SCHLUSSELWORT")
    private String Schlusselwort;
    @Column(name = "PREIS")
    private Long preis;
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "BESCHREIBUNG")
    private String beschreibung;
    @Column(name = "TERMIN")
    private String termin;
}
