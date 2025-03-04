package com.java.isi.gestion_prof.service;

import com.java.isi.gestion_prof.model.Matiere;
import com.java.isi.gestion_prof.repository.MatiereRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatiereService {

    private final MatiereRepository matiereRepository;

    public List<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    public Optional<Matiere> getMatiereById(Long id) {
        return matiereRepository.findById(id);
    }

    public Matiere saveMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    public Matiere updateMatiere(Long id, Matiere matiereDetails) {
        return matiereRepository.findById(id).map(matiere -> {
            matiere.setLibelle(matiereDetails.getLibelle());
            matiere.setDesignation(matiereDetails.getDesignation());
            return matiereRepository.save(matiere);
        }).orElseThrow(() -> new RuntimeException("Matière non trouvée avec l'ID : " + id));
    }

    public void deleteMatiere(Long id) {
        matiereRepository.deleteById(id);
    }
}
