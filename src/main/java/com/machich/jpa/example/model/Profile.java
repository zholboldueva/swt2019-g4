package com.machich.jpa.example.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Column(name = "Ausstellungsland")
    private String ausstellungsland;

    @Column(name = "user_u")
    private User user;

    @Transient
    private MultipartFile userImage;

    public Profile(User user){
        this.user=user;
    }

    public Profile(){}


    public String adressToString(){
        return street+", "+postCode+", "+city;
    }


}
