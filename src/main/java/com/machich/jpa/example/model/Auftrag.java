package com.machich.jpa.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
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
    private String schlusselwort;
    @Column(name = "PREIS")
    private Long preice;
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "BESCHREIBUNG")
    private String beschreibung;
    @Column(name = "TERMIN")
    private Date termin;

    @Override
    public String toString() {
        return "AUFTRAG_ID [id=" + id + ", kategory=" + kategory + ", schlusselwort=" + schlusselwort +", title=" + title + ", price=" + preice + ", adress=" + adress + ", beschreibung=" +", termin" + termin + "]";
    }

}
