package com.wildBirds.checksummservice.domain.port;

import com.wildBirds.checksummservice.domain.model.InnNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InnNumberRepository extends JpaRepository<InnNumber, Integer> {


}
