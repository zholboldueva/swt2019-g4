package com.machich.jpa.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "MACHER")
public class Macher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MACHER_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MACHER_ANGEBOT", joinColumns = @JoinColumn(name = "MACHER_ID"), inverseJoinColumns = @JoinColumn(name = "ANGEBOT_ID"))
    private List<Angebot> auftraglists;

    public Macher(User user, Angebot angebot, Profile profile){
        this.name=user.getName();
        this.lastname=user.getLastName();
        this.email=user.getEmail();
    }


}
