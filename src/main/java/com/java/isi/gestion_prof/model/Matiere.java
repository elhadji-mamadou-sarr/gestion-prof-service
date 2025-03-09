package com.java.isi.gestion_prof.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Builder;

@Entity
@Builder
public class Matiere {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String libelle;

    @Column(nullable = false, length = 100)
    private String designation;

    public Matiere() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
