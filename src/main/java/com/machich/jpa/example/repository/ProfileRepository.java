package com.machich.jpa.example.repository;

import com.machich.jpa.example.model.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="profileRepository")
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findByEmail(String email);
}
