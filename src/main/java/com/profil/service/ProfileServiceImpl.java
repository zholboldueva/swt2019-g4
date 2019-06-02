package com.profil.service;

import com.profil.model.Profile;
import org.springframework.stereotype.Service;

@Service(value="profileService")
public class ProfileServiceImpl implements ProfileService {


    @Override
    public Profile saveProfile(Profile profile) {
        return profile;
    }
}
