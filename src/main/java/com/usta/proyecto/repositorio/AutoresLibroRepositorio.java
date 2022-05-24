package com.usta.proyecto.repositorio;

import com.usta.proyecto.model.AutoresLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutoresLibroRepositorio extends JpaRepository<AutoresLibro, Long> {
    @Query("SELECT count(al) FROM AutoresLibro al")
    public Integer countTotalAutoresLibro();
}
