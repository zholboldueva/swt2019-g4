package com.machich.jpa.example.controller;

import com.machich.jpa.example.model.Kunde;
import com.machich.jpa.example.repository.AuftragRepository;
import com.machich.jpa.example.repository.KundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class KundenController {
    @Qualifier("kundeRepository")
    @Autowired
     KundeRepository kundeRepository;

    @Qualifier("auftragRepository")
    @Autowired
    AuftragRepository auftragRepository;

    @RequestMapping("/user")
    public String index(Model model) {
        List<Kunde> kunden = (List<Kunde>) kundeRepository.findAll();
      model.addAttribute("kunden", kunden);
        return "kunden";
    }





}
