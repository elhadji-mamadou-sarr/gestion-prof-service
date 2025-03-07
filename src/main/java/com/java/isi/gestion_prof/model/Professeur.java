package com.java.isi.gestion_prof.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Professeur {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 100)
    private String prenom;

    private String email;

    private String telephone;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;
}
