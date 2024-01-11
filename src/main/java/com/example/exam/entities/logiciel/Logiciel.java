package com.example.exam.entities.logiciel;

import com.example.exam.entities.Categorie;
import com.example.exam.entities.Composant;
import com.example.exam.entities.Licence;
import com.example.exam.entities.Version;
import com.example.exam.entities.ids.LogicielId;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.net.URL;
import java.util.List;


@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Logiciel {

    @EmbeddedId
    protected LogicielId id;

    @Column(nullable = false)
    protected String description;

    @Column(nullable = false)
    protected String url;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "logiciel_nom", referencedColumnName = "nom"),
            @JoinColumn(name = "logiciel_majeure", referencedColumnName = "majeure"),
            @JoinColumn(name = "logiciel_mineure", referencedColumnName = "mineure"),
    })
    private List<Composant> composants;

    @ManyToMany(mappedBy = "logiciels", fetch = FetchType.EAGER)
    private List<Licence> licences;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorie_principale", referencedColumnName = "id")
    private Categorie categorie_principale;

    @ManyToMany(mappedBy = "logiciels_secondaire", fetch = FetchType.EAGER)
    private List<Categorie> categories_secondaire;

    @ManyToMany(mappedBy = "logiciels", fetch = FetchType.EAGER)
    private List<Application> applications;

    public Logiciel() {}

    public Logiciel(String nom, com.example.exam.entities.Version version, String description, String url) {
        this.description = description;
        this.url = url;
        this.id = new LogicielId(nom,version);
    }

    public LogicielId getId() {
        return id;
    }

    public void setId(LogicielId id) {
        this.id = id;
    }

    public String getNom() {
        return this.id.getNom();
    }

    public void setNom(String nom) {
        this.id.setNom(nom);
    }

    public com.example.exam.entities.Version getVersion() {
        return this.id.getVersion();
    }

    public void setVersion(Version version) {
        this.id.setVersion(version);
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Licence> getLicences() {
        return licences;
    }

    public void setLicences(List<Licence> licences) {
        this.licences = licences;
    }

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }

    public Categorie getCategorie_principale() {
        return categorie_principale;
    }

    public void setCategorie_principale(Categorie categorie_principale) {
        this.categorie_principale = categorie_principale;
    }

    public List<Categorie> getCategories_secondaire() {
        return categories_secondaire;
    }

    public void setCategories_secondaire(List<Categorie> categories_secondaire) {
        this.categories_secondaire = categories_secondaire;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
