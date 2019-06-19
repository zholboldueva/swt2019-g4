package com.machich.jpa.example.controller;

import com.machich.jpa.example.model.Profile;
import com.machich.jpa.example.model.Role;
import com.machich.jpa.example.model.User;
import com.machich.jpa.example.service.ProfileService;
import com.machich.jpa.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {


    @Autowired
    private UserService userService;
    @Autowired
    ProfileService profileService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, @Valid Role role, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "Benutzer mit der angegebenen E-Mail schon registriert");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveRole(role);
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Der Benutzer wurde erfolgreich registriert");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/user/userHome", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Willkommen " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("userMessage", "Um eine Anzeige zu erstellen, gehen Sie zum Menü");
        modelAndView.setViewName("/user/userHome");
        return modelAndView;
    }


    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public ModelAndView profileSite() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        Profile profile=new Profile(user);
        modelAndView.addObject("profile", profile);
        modelAndView.addObject("profile_Name", profile.getName());
        modelAndView.addObject("profile_LName", profile.getLastname());
        modelAndView.addObject("profile_Email", profile.getEmail());
        modelAndView.setViewName("/user/profile");
        return modelAndView;
    }

    @RequestMapping(value = "/user/auftragPage", method = RequestMethod.GET)
    public ModelAndView auftragSite() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/auftragPage");
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



}
