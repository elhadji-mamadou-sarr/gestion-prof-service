package com.java.isi.gestion_prof.service;

import com.java.isi.gestion_prof.model.Professeur;
import com.java.isi.gestion_prof.repository.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesseurService {

    private final ProfesseurRepository professeurRepository;

    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    public Optional<Professeur> getProfesseurById(Long id) {
        return professeurRepository.findById(id);
    }

    public Professeur saveProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    public void deleteProfesseur(Long id) {
        professeurRepository.deleteById(id);
    }

    public Professeur updateProfesseur(Long id, Professeur professeurDetails) {
        return professeurRepository.findById(id).map(professeur -> {
            professeur.setNom(professeurDetails.getNom());
            professeur.setPrenom(professeurDetails.getPrenom());
            professeur.setEmail(professeurDetails.getEmail());
            professeur.setTelephone(professeurDetails.getTelephone());
            professeur.setMatiere(professeurDetails.getMatiere());
            return professeurRepository.save(professeur);
        }).orElseThrow(() -> new RuntimeException("Professeur non trouvé avec l'ID : " + id));
    }
}
