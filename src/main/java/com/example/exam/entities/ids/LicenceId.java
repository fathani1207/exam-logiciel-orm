package com.example.exam.entities.ids;


import com.example.exam.entities.Version;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.io.Serializable;

@Embeddable
public class LicenceId implements Serializable {

    private String nom;

    @Embedded
    private Version version;

    private String langue;

    public LicenceId() {
    }

    public LicenceId(String nom, Version version, String langue) {
        this.nom = nom;
        this.version = version;
        this.langue = langue;
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

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }
}
