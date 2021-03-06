package com.wildBirds.checksummservice.infrastructure;

import com.wildBirds.checksummservice.application.service.InvalidIssuerException;
import com.wildBirds.checksummservice.domain.model.Issuer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class IssuerRepositoryIml {

    @PersistenceContext
    EntityManager entityManager = null;

    @Transactional
    public Issuer getIssuer(List<String> innList) {
        try {
            String query = "SELECT issuer FROM Issuer issuer " +
                    "JOIN issuer.innNumberSet innNumber " +
                    "WHERE innNumber.iinNumber in :integerList";

            return entityManager.createQuery(query, Issuer.class)
                    .setParameter("integerList", innList)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            throw new InvalidIssuerException("Issuer not found");
        }
    }

}
