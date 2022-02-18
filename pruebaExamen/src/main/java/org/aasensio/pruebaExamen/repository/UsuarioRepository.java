package org.aasensio.pruebaExamen.repository;

import org.aasensio.pruebaExamen.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
