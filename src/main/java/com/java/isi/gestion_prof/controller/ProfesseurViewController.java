package com.java.isi.gestion_prof.controller;

import com.java.isi.gestion_prof.model.Matiere;
import com.java.isi.gestion_prof.model.Professeur;
import com.java.isi.gestion_prof.service.MatiereService;
import com.java.isi.gestion_prof.service.ProfesseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view/professeurs")
public class ProfesseurViewController {

    private final ProfesseurService professeurService;
    private final MatiereService matiereService;


    @GetMapping
    public String listProfesseurs(Model model) {
        List<Professeur> professeurs = professeurService.getAllProfesseurs();
        model.addAttribute("professeurs", professeurs);
        return "professeurs/list";
    }

    @PostMapping("/add")
    public String addProfesseur(@ModelAttribute Professeur professeur) {
//        Professeur professeur = Professeur.builder()
//                .nom(nom)
//                .prenom(prenom)
//                .email(email)
//                .telephone(telephone)
//                .build();
        professeurService.saveProfesseur(professeur);
        return "redirect:/professeurs";
    }


    @GetMapping("/edit/{id}")
    public String editProfesseurForm(@PathVariable Long id, Model model) {
        Professeur professeur = professeurService.getProfesseurById(id)
                .orElseThrow(() -> new RuntimeException("Professeur non trouvé"));
        List<Matiere> matieres = matiereService.getAllMatieres();

        model.addAttribute("professeur", professeur);
        model.addAttribute("matieres", matieres);
        return "professeurs/edit";
    }

    @PostMapping("/update")
    public String updateProfesseur(@RequestParam Long id, @ModelAttribute Professeur professeur, @RequestParam Long matiereId) {
        Matiere matiere = matiereService.getMatiereById(matiereId)
                .orElseThrow(() -> new RuntimeException("Matière non trouvée"));
        professeur.setMatiere(matiere);
        professeurService.updateProfesseur(id, professeur);
        return "redirect:/professeurs";
    }


}
