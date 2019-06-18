package com.machich.jpa.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "KUNDE")
public class Kunde {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "KUNDE_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "Auftrag")
    @ElementCollection(targetClass=Auftrag.class)
    private List<Auftrag> auftraglists;

    public Kunde(User user, List<Auftrag> anfrage, Profile profile){
        this.name=user.getName();
        this.lastname=user.getLastName();
        this.email=user.getEmail();
        this.adress=profile.adressToString();
        this.auftraglists=anfrage;

    }


}
