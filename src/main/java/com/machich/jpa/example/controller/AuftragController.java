package com.machich.jpa.example.controller;

import com.machich.jpa.example.model.Auftrag;
import com.machich.jpa.example.model.Kunde;
import com.machich.jpa.example.repository.AuftragRepository;
import com.machich.jpa.example.repository.KundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AuftragController {

    @Qualifier("kundeRepository")
    @Autowired
    KundeRepository kundenRepository;

    @Qualifier("auftragRepository")
    @Autowired
    AuftragRepository auftragsRepository;

    @RequestMapping(value = "add")
    public String addStudent(Model model) {
        model.addAttribute("auftrag", new Auftrag());
        return "addAuftrag";
    }

//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public String save(@Valid Kunde kunde) {
//        kundenRepository.save(kunde);
//        return "redirect:/userHome";
//    }

}
