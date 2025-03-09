package com.java.isi.gestion_prof.controller;

import com.java.isi.gestion_prof.model.Matiere;
import com.java.isi.gestion_prof.service.MatiereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/matieres")
public class MatiereViewController {

    private final MatiereService matiereService;

    public MatiereViewController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    @GetMapping
    public String listMatieres(Model model) {
        model.addAttribute("matieres", matiereService.getAllMatieres());
        return "matieres/list";
    }

    @GetMapping("/edit/{id}")
    public String editMatiereForm(@PathVariable Long id, Model model) {
        Matiere matiere = matiereService.getMatiereById(id)
                .orElseThrow(() -> new RuntimeException("Matière non trouvée"));
        model.addAttribute("matiere", matiere);
        return "matieres/edit";
    }

    @PostMapping("/update")
    public String updateMatiere(@RequestParam Long id, @RequestParam String libelle,
                                @RequestParam String designation) {
        Matiere matiere = Matiere.builder()
                .id(id)
                .libelle(libelle)
                .designation(designation)
                .build();
        matiereService.updateMatiere(id, matiere);
        return "redirect:/matieres";
    }
}
