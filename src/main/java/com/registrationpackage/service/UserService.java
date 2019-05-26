package com.registrationpackage.service;

import com.registrationpackage.model.Role;
import com.registrationpackage.model.User;

public interface UserService {

    User findUserByEmail(String email) ;
    Role saveRole(Role role);
    User saveUser(User user);
}
