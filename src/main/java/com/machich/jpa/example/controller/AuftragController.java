package com.machich.jpa.example.controller;

import com.machich.jpa.example.model.*;
import com.machich.jpa.example.repository.AuftragRepository;
import com.machich.jpa.example.repository.KundeRepository;
import com.machich.jpa.example.service.AuftragService;
import com.machich.jpa.example.service.KundeService;
import com.machich.jpa.example.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class AuftragController {

    @Autowired
    AuftragService auftragService;

    @Autowired
    KundeService kundeService;

    @RequestMapping(value = "/user/auftragPage", method = RequestMethod.GET)
    public ModelAndView auftragSite() {
        ModelAndView modelAndView = new ModelAndView();
        Auftrag auftrag = new Auftrag();
        modelAndView.addObject("auftrag", auftrag);
        modelAndView.setViewName("/user/auftragPage");
        return modelAndView;
    }

    @RequestMapping(value = "/user/auftragPage", method = RequestMethod.POST)
    public ModelAndView saveAuftrag(@Valid Auftrag auftrag, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/user/auftragPage");
        } else {
            auftragService.saveAuftrag(auftrag);
            modelAndView.addObject("auftrag", new Auftrag());
            modelAndView.addObject("successMessage", "Die Auftrag wurde erfolgreich gespeichert");
            modelAndView.setViewName("/user/auftragPage");
        }
        return modelAndView;
    }


}
