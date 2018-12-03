package com.wildBirds.checksummservice.application;


public class IssuerDTO {
    private String name;

    public IssuerDTO(String name) {
        this.name = name;
    }

    public IssuerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
