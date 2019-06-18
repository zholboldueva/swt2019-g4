package com.machich.jpa.example.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int id;
    @Column(name = "EMAIL")
    @Email(message = "*Bitte geben Sie eine gültige E-Mail")
    @NotEmpty(message = "*Bitte geben Sie eine E-Mail an")
    private String email;
    @Column(name = "PASSWORD")
    @Length(min = 5, message = "*Passwort muss mindestens 5 Zeichen lang sein")
    @NotEmpty(message = "*Bitte geben Sie Ihr Passwort ein")
    private String password;
    @Column(name = "NAME")
    @NotEmpty(message = "*Bitte geben Sie Ihren Vornamen an")
    private String name;
    @Column(name = "LAST_NAME")
    @NotEmpty(message = "*Bitte geben Sie Ihren Nachnamen an")
    private String lastName;
    @Column(name = "ACTIVE")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles;

}