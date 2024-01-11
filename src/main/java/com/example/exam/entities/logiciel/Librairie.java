package com.example.exam.entities.logiciel;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Librairie extends Logiciel{

    @ManyToMany(mappedBy = "dependOnMe", fetch = FetchType.EAGER)
    private List<Librairie> dependencies;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dependencies_relation",
            joinColumns = {
                    @JoinColumn(name = "dependencie_nom", referencedColumnName = "nom"),
                    @JoinColumn(name = "dependencie_majeure", referencedColumnName = "majeure"),
                    @JoinColumn(name = "dependencie_mineure", referencedColumnName = "mineure")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "depend_on_me_nom", referencedColumnName = "nom"),
                    @JoinColumn(name = "depend_on_me_majeure", referencedColumnName = "majeure"),
                    @JoinColumn(name = "depend_on_me_mineure", referencedColumnName = "mineure")
            }
    )
    private List<Librairie> dependOnMe;
}
