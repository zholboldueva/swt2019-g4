package com.profil.repository;

import com.profil.model.Profile;
import com.registrationpackage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="profileRepository")
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findByUser(User user);
}
