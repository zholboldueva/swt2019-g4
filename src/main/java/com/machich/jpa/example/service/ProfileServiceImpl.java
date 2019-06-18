package com.machich.jpa.example.service;

import com.machich.jpa.example.model.Profile;
import com.machich.jpa.example.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "profileService")
public class ProfileServiceImpl implements ProfileService {

    ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(@Qualifier("profileRepository") ProfileRepository profileRepository){
        this.profileRepository=profileRepository;
    }

    @Override
    public Profile saveProfile(Profile profile) {
        profile.setE_purse(new Long(100));
        return profileRepository.save(profile);
    }

    @Override
    public Profile findProfileByEmail(String email) {

        return profileRepository.findByEmail(email);
    }
}
