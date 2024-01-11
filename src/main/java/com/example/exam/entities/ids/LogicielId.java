package com.example.exam.entities.ids;

import com.example.exam.entities.Version;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.io.Serializable;

@Embeddable
public class LogicielId implements Serializable {

    private String nom;

    @Embedded
    private Version version;

    public LogicielId() {
    }

    public LogicielId(String nom, Version version) {
        this.nom = nom;
        this.version = version;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
