package com.java.isi.gestion_prof.controller;

import com.java.isi.gestion_prof.model.Professeur;
import com.java.isi.gestion_prof.service.ProfesseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/professeurs")
@RequiredArgsConstructor
public class ProfesseurRestController {

    private final ProfesseurService professeurService;

    @GetMapping
    public List<Professeur> getAllProfesseurs() {
        return professeurService.getAllProfesseurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professeur> getProfesseurById(@PathVariable Long id) {
        return professeurService.getProfesseurById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Professeur createProfesseur(@RequestBody Professeur professeur) {
        return professeurService.saveProfesseur(professeur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professeur> updateProfesseur(@PathVariable Long id, @RequestBody Professeur professeurDetails) {
        try {
            Professeur updatedProfesseur = professeurService.updateProfesseur(id, professeurDetails);
            return ResponseEntity.ok(updatedProfesseur);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesseur(@PathVariable Long id) {
        professeurService.deleteProfesseur(id);
        return ResponseEntity.noContent().build();
    }
}
