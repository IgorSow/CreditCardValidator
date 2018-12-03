package com.wildBirds.checksummservice.domain.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Issuer extends BaseEntity{

    @Column(unique = true)
    private String issuerName;

    @OneToMany(mappedBy = "issuer", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<InnNumber> innNumberSet;


    public Issuer() {
    }

    public Issuer(String issuerName) {
        this.issuerName = issuerName;
        this.innNumberSet = new HashSet<>();
    }

    public void addInnNumber(InnNumber innNumber){
        innNumberSet.add(innNumber);
        innNumber.setIssuer(this);
    }
    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public Set<InnNumber> getInnNumberSet() {
        return innNumberSet;
    }

    public void setInnNumberSet(Set<InnNumber> innNumberSet) {
        this.innNumberSet = innNumberSet;
    }

    @Override
    public String toString() {
        return "Issuer{" +
                "issuerName='" + issuerName + '\'' +
                '}';
    }
}
