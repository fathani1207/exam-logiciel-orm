package com.example.exam.entities;

import com.example.exam.entities.ids.LicenceId;
import com.example.exam.entities.logiciel.Logiciel;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table
public class Licence {

    @EmbeddedId
    private LicenceId id;

    @Lob
    private String texte;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "logiciel_licence",
            joinColumns = {
                    @JoinColumn(name = "licence_nom", referencedColumnName = "nom"),
                    @JoinColumn(name = "licence_majeure", referencedColumnName = "majeure"),
                    @JoinColumn(name = "licence_mineure", referencedColumnName = "mineure"),
                    @JoinColumn(name = "licence_langue", referencedColumnName = "langue")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "logiciel_nom", referencedColumnName = "nom"),
                    @JoinColumn(name = "logiciel_majeure", referencedColumnName = "majeure"),
                    @JoinColumn(name = "logiciel_mineure", referencedColumnName = "mineure"),
            }
    )
    private List<Logiciel> logiciels;

    @ManyToMany(mappedBy = "licences", fetch = FetchType.EAGER)
    private List<Composant> composants;

    public Licence() {
    }

    public Licence(String nom, Version version, String langue, String texte) {
        this.texte = texte;
        this.id = new LicenceId(nom, version, langue);
    }

    public LicenceId getId() {
        return id;
    }

    public void setId(LicenceId id) {
        this.id = id;
    }

    public String getNom() {
        return this.id.getNom();
    }

    public void setNom(String nom) {
        this.id.setNom(nom);
    }

    public Version getVersion() {
        return this.id.getVersion();
    }

    public void setVersion(Version version) {
        this.id.setVersion(version);
    }

    public String getLangue() {
        return this.id.getLangue();
    }

    public void setLangue(String langue) {
        this.id.setLangue(langue);
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public List<Logiciel> getLogiciels() {
        return logiciels;
    }

    public void setLogiciels(List<Logiciel> logiciels) {
        this.logiciels = logiciels;
    }

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }
}
