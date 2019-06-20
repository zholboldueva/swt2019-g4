package com.machich.jpa.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "AUFTRAG")
public class Auftrag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AUFTRAG_ID")
    private int id;
    @Column(name = "KATEGORY")
    private Category kategory;
    @Column(name = "TITEL")
    private String title;
    @Column(name = "SCHLUSSELWORT")
    @ElementCollection(targetClass=String.class)
    private List<String> schlusselwort;
    @Column(name = "PREIS")
    private Long preice;
    @Column(name = "Ort")
    private String ort;
    @Column(name = "Plz")
    private String plz;
    @Column(name = "BESCHREIBUNG")
    private String beschreibung;
   @Column(name = "TERMIN")
    private String termin;

    public Auftrag(){}


}
