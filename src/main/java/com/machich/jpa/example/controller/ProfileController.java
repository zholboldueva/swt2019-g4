package com.machich.jpa.example.controller;

import com.machich.jpa.example.model.Profile;
import com.machich.jpa.example.model.User;
import com.machich.jpa.example.service.ProfileService;
import com.machich.jpa.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    ProfileService profileService;

    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public ModelAndView profileSite() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        Profile profile = profileService.findProfileByEmail(user.getEmail());
        if (profile != null) {
            modelAndView.addObject("profile", profile);
            modelAndView.addObject("profile_Name", profile.getName());
            modelAndView.addObject("profile_LName", profile.getLastname());
            modelAndView.addObject("profile_Email", profile.getEmail());
            modelAndView.addObject("e_purse", profile.getE_purse());
            modelAndView.addObject("street", profile.getStreet());
            modelAndView.addObject("postCode", profile.getPostCode());
            modelAndView.addObject("city", profile.getCity());
            modelAndView.addObject("telNr", profile.getTelNr());
            modelAndView.addObject("passportNr", profile.getPassportNr());
            modelAndView.addObject("ausstellungsland", profile.getAusstellungsland());
            modelAndView.setViewName("/user/savedProfile");
        } else {
            profile = new Profile(user);
            modelAndView.addObject("profile", profile);
            modelAndView.addObject("profile_Name", profile.getName());
            modelAndView.addObject("profile_LName", profile.getLastname());
            modelAndView.addObject("profile_Email", profile.getEmail());
            modelAndView.setViewName("/user/profile");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/user/profile", method = RequestMethod.POST)
    public ModelAndView saveProfile(@Valid Profile profile, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/user/profile");
        } else {
            profile.setName(user.getName());
            profile.setEmail(user.getEmail());
            profile.setLastname(user.getLastName());
            profileService.saveProfile(profile);
            modelAndView.addObject("profile", new Profile(user));
            modelAndView.addObject("successMessage", "Die Profile wurde erfolgreich gespeichert");
            modelAndView.setViewName("/user/profile");
        }
        return modelAndView;
    }

    @RequestMapping(value = "image/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {

        File serverFile = new File("/homes/uploads/" + imageName + ".jpg");

        return Files.readAllBytes(serverFile.toPath());
    }
}
