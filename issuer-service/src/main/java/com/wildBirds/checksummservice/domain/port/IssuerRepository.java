package com.wildBirds.checksummservice.domain.port;

import com.wildBirds.checksummservice.domain.model.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuerRepository extends JpaRepository<Issuer, Integer> {



}
