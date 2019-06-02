package com.kunde.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "ANGEBOT")
public class Angebot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ANGEBOT_ID")
    private int id;
    @Column(name = "CATEGORY")
    private Category category;
    @Column(name = "KOMPETENZ")
    private List<String> kompetenzenList;
    @Column(name = "ORT")
    private String ort;
    @Column(name = "PREIS")
    private Long preis;
    @Column(name = "CERTIFICATE")
    private String certificate;

}
