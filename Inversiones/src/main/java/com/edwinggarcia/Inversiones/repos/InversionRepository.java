package com.edwinggarcia.Inversiones.repos;

import com.edwinggarcia.Inversiones.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InversionRepository extends JpaRepository<Inversion, Long> {
    List<Inversion> findByEmailUsuario(String emailUsuario);
}
