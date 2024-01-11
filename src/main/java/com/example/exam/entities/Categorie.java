package com.example.exam.entities;

import com.example.exam.entities.logiciel.Logiciel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    @OneToMany(mappedBy = "categorie_principale", fetch = FetchType.EAGER)
    private List<Logiciel> logiciels_principales;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "categorie_logiciel_secondaire",
            joinColumns = {
                    @JoinColumn(name = "categorie_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "logiciel_nom", referencedColumnName = "nom"),
                    @JoinColumn(name = "logiciel_majeure", referencedColumnName = "majeure"),
                    @JoinColumn(name = "logiciel_mineure", referencedColumnName = "mineure"),
            }
    )
    private List<Logiciel> logiciels_secondaire;

    public Categorie() {
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Logiciel> getLogiciels_principales() {
        return logiciels_principales;
    }

    public void setLogiciels_principales(List<Logiciel> logiciels_principales) {
        this.logiciels_principales = logiciels_principales;
    }

    public List<Logiciel> getLogiciels_secondaire() {
        return logiciels_secondaire;
    }

    public void setLogiciels_secondaire(List<Logiciel> logiciels_secondaire) {
        this.logiciels_secondaire = logiciels_secondaire;
    }
}
