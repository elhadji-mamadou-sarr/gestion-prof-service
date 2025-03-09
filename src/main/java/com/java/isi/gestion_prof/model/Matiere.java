package com.java.isi.gestion_prof.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
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



}
