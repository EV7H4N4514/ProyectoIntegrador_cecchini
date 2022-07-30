package com.portfolio.cecchini.Repository;

import com.portfolio.cecchini.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findBynombreEdu (String nombreEdu);
    public boolean existsByNombreEdu(String nombreEdu);
}
