package com.machich.jpa.example.service;


import com.machich.jpa.example.model.Role;
import com.machich.jpa.example.model.User;

public interface UserService {

    User findUserByEmail(String email) ;
    Role saveRole(Role role);
    User saveUser(User user);
}
