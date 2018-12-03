package com.wildBirds.cardvalidator.application.DTO;

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

    @Override
    public String toString() {
        return "IssuerDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
