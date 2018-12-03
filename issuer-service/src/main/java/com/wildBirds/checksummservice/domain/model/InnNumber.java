package com.wildBirds.checksummservice.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class InnNumber extends BaseEntity {

    @Column(unique = true)
    private String iinNumber;

    @ManyToOne
    @JoinColumn(name = "idIssuer")
    private Issuer issuer;

    public InnNumber() {
    }

    public InnNumber(String iinNumber) {
        this.iinNumber = iinNumber;
    }

    public String getIinNumber() {
        return iinNumber;
    }

    public void setIinNumber(String iinNumber) {
        this.iinNumber = iinNumber;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
        issuer.getInnNumberSet().add(this);
    }
}
