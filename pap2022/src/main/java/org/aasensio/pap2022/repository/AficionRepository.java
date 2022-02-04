package org.aasensio.pap2022.repository;

import org.aasensio.pap2022.entities.Aficion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AficionRepository extends JpaRepository<Aficion, Long>{

}
