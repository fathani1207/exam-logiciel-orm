package com.example.exam.entities.logiciel;

import com.example.exam.entities.Version;
import jakarta.persistence.*;

import java.net.URL;
import java.util.List;

@Entity
public class Application extends Logiciel{

    @Column(unique = true)
    private String urlApp;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "logiciel_application",
            joinColumns = {
                @JoinColumn(name = "app_url", referencedColumnName = "urlApp"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "logiciel_nom", referencedColumnName = "nom"),
                    @JoinColumn(name = "logiciel_majeure", referencedColumnName = "majeure"),
                    @JoinColumn(name = "logiciel_mineure", referencedColumnName = "mineure"),
            }
    )
    private List<Logiciel> logiciels;

    public Application(){}

    public Application(String nom, Version version, String description, String url) {
        super(nom, version, description, url);
        this.urlApp = url;
    }

    public String getUrlApp() {
        return super.getUrl();
    }

    public void setUrlApp(String url) {
        this.urlApp = url;
        super.setUrl(url);
    }

    public List<Logiciel> getLogiciels() {
        return logiciels;
    }

    public void setLogiciels(List<Logiciel> logiciels) {
        this.logiciels = logiciels;
    }

    @Override
    public String toString() {
        return "Application{" +
                "urlApp='" + urlApp + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
