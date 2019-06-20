package com.machich.jpa.example.controller;

import com.machich.jpa.example.model.Angebot;
import com.machich.jpa.example.model.Auftrag;
import com.machich.jpa.example.service.AngebotService;
import com.machich.jpa.example.service.AuftragService;
import com.machich.jpa.example.service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class AngebotController {


    @Autowired
    AngebotService angebotService;


        @RequestMapping(value = "/user/angebot", method = RequestMethod.GET)
        public ModelAndView angebotSite() {
            ModelAndView modelAndView = new ModelAndView();
            Angebot angebot = new Angebot();
            modelAndView.addObject("angebot", angebot);
            modelAndView.setViewName("/user/angebot");
            return modelAndView;
        }

        @RequestMapping(value = "/user/angebot", method = RequestMethod.POST)
        public ModelAndView saveAuftrag(@Valid Angebot angebot, BindingResult bindingResult) {
            ModelAndView modelAndView = new ModelAndView();
            if (bindingResult.hasErrors()) {
                modelAndView.setViewName("/user/angebot");
            } else {
                angebotService.saveAngebot(angebot);
                modelAndView.addObject("angebot", new Angebot());
                modelAndView.addObject("successMessage", "Die Angebot wurde erfolgreich gespeichert");
                modelAndView.setViewName("/user/angebot");
            }
            return modelAndView;
        }


    }


