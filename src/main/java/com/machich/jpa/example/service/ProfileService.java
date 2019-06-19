package com.machich.jpa.example.service;

import com.machich.jpa.example.model.Profile;

public interface ProfileService {
    void saveProfile(Profile profile);
    Profile findProfileByEmail(String email);


}
