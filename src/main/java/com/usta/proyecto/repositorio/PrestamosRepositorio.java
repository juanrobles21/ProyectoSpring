package com.usta.proyecto.repositorio;

import com.usta.proyecto.model.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrestamosRepositorio extends JpaRepository<Prestamos, Long> {
    @Query("SELECT count(p) FROM Prestamos p")
    public Integer countTotalPrestamos();
}
