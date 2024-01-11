package com.example.exam.entities;


import jakarta.persistence.Embeddable;

@Embeddable
public class Version {
    private int majeure;
    private int mineure;

    public Version() {
    }

    public Version(int majeure, int mineure) {
        this.majeure = majeure;
        this.mineure = mineure;
    }

    public int getMajeure() {
        return majeure;
    }

    public void setMajeure(int majeure) {
        this.majeure = majeure;
    }

    public int getMineure() {
        return mineure;
    }

    public void setMineure(int mineure) {
        this.mineure = mineure;
    }
}
