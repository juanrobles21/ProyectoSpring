package com.usta.proyecto.repositorio;

import com.usta.proyecto.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    @Query("SELECT count(l) FROM Libro l")
    public Integer countTotalLibros();

    @Query(value = "SELECT l.titulo, l.fechaPublicacion, l.codigo, l.isbn, p.fechaInicio, c.nombre, c.apellido  " +
            "FROM Libro l " +
            "INNER JOIN DetallePrestamos dp " +
            "ON l.idLibro = dp.fkLibro.idLibro " +
            "INNER JOIN Prestamos p " +
            "ON p.idPrestamo = dp.fkPrestamos.idPrestamo " +
            "INNER JOIN Cliente c " +
            "ON c.idCliente = p.fkCliente.idCliente " +
            "WHERE dp.idDetallePrestamo= :id")
    public List<String> LibroByIdDetallePrestamo(Long id);


}
