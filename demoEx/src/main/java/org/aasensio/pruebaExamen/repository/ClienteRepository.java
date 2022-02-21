package org.aasensio.pruebaExamen.repository;

import org.aasensio.pruebaExamen.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
