package com.kunde.model;

import com.profil.model.Profile;
import com.registrationpackage.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "KUNDE_AUFTRAG", joinColumns = @JoinColumn(name = "KUNDE_ID"), inverseJoinColumns = @JoinColumn(name = "AUFTRAG_ID"))
    private List<Anfrage> auftraglists;

    public Kunde(User user, Anfrage anfrage, Profile profile){
        this.name=user.getName();
        this.lastname=user.getLastName();
        this.email=user.getEmail();
        this.adress=profile.adressToString();

    }


}
