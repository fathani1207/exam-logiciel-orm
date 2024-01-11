package com.example.exam.entities.ids;

import com.example.exam.entities.Version;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.io.Serializable;

@Embeddable
public class ComposantId implements Serializable {

    private String code;

    @Embedded
    private Version version;

    public ComposantId() {
    }

    public ComposantId(String code, Version version) {
        this.code = code;
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
