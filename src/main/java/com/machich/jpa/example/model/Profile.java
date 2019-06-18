package com.machich.jpa.example.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "PROFILE")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROFILE_ID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Lastname")
    private String lastname;

    @Column(name = "dateBirth")
    private Date dateBirth;

    @Column(name = "E_purse")
    private Long e_purse;

    @Column(name = "Street")
    private String street;

    @Column(name = "postCode")
    private String postCode;

    @Column(name = "City")
    private String city;

    @Column(name = "Email")
    private String email;

    @Column(name = "TelNr")
    private String telNr;

    @Column(name = "PassportNr")
    private String passportNr;

    @Transient
    private MultipartFile userImage;

    public Profile(User user){
        this.name=user.getName();
        this.lastname=user.getLastName();
        this.email=user.getEmail();
    }

    public String adressToString(){
        return street+", "+postCode+", "+city;
    }


}
