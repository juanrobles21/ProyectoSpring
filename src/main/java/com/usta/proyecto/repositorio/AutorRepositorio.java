package com.usta.proyecto.repositorio;

import com.usta.proyecto.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {
    @Query("SELECT count(a) FROM Autor a")
    public Integer countTotalAutor();
}