package com.machich.jpa.example.controller;

import com.machich.jpa.example.model.Profile;
import com.machich.jpa.example.model.User;
import com.machich.jpa.example.repository.ProfileRepository;
import com.machich.jpa.example.service.ProfileService;
import com.machich.jpa.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {


    @Autowired
    ProfileService profileService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("profile", user);
        modelAndView.addObject("profile_Name", user.getName());
        modelAndView.addObject("profile_LName", user.getLastName());
        modelAndView.addObject("profile_Email", user.getEmail());
        modelAndView.setViewName("/user/profile");
        return modelAndView;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public ModelAndView saveProfile() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        Profile profile = new Profile(user);
        profileService.saveProfile(profile);
        modelAndView.addObject("successMessage", "Die Profile wurde erfolgreich gespeichert");
        modelAndView.setViewName("/user/profile");
        return modelAndView;
    }
}
