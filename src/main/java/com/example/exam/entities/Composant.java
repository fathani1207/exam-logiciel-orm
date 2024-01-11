package com.example.exam.entities;

import com.example.exam.entities.ids.ComposantId;
import jakarta.persistence.*;

import java.net.URL;
import java.util.List;

@Entity
@Table
public class Composant {

    @EmbeddedId
    private ComposantId id;

    private String description;

    private URL url;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "licence_composant",
            joinColumns = {
                    @JoinColumn(name = "composant_code", referencedColumnName = "code"),
                    @JoinColumn(name = "composant_majeure", referencedColumnName = "majeure"),
                    @JoinColumn(name = "composant_mineure", referencedColumnName = "mineure"),
            }
            ,
            inverseJoinColumns = {
                  @JoinColumn(name = "licence_nom", referencedColumnName = "nom"),
                  @JoinColumn(name = "licence_majeure", referencedColumnName = "majeure"),
                  @JoinColumn(name = "licence_mineure", referencedColumnName = "mineure"),
                  @JoinColumn(name = "licence_langue", referencedColumnName = "langue"),
            }
    )
    private List<Licence> licences;

    public Composant() {
    }

    public Composant(String code, Version version, String description, URL url) {
        this.description = description;
        this.url = url;
        this.id = new ComposantId(code, version);
    }

    public ComposantId getId() {
        return id;
    }

    public void setId(ComposantId id) {
        this.id = id;
    }

    public String getCode() {
        return this.id.getCode();
    }

    public void setCode(String code) {
        this.id.setCode(code);
    }

    public Version getVersion() {
        return this.id.getVersion();
    }

    public void setVersion(Version version) {
        this.id.setVersion(version);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public List<Licence> getLicences() {
        return licences;
    }

    public void setLicences(List<Licence> licences) {
        this.licences = licences;
    }
}
