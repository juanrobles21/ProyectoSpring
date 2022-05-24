package com.usta.proyecto.repositorio;

import com.usta.proyecto.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EditorialRepositorio extends JpaRepository<Editorial, Long> {
    @Query("SELECT count(e) FROM Editorial e")
    public Integer countTotalEditorial();

    @Query(value = "SELECT e.idEditorial, e.nombre, e.pais, e.telefono, l.titulo  " +
            "FROM Editorial e " +
            "INNER JOIN Libro l " +
            "ON e.idEditorial = l.fkEditorial.idEditorial " +
            "WHERE l.idLibro = :id")
    public List<String> editorialByIdLibro(Long id);

}
