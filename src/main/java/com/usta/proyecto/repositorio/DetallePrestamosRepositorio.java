package com.usta.proyecto.repositorio;

import com.usta.proyecto.model.DetallePrestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetallePrestamosRepositorio extends JpaRepository<DetallePrestamos, Long> {
    @Query("SELECT count(dp) FROM DetallePrestamos dp")
    public Integer countTotalDetallePrestamos();
}
