package com.usta.proyecto.repositorio;

import com.usta.proyecto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    @Query("SELECT count(c) FROM Cliente c")
    public Integer countTotalCliente();

    @Query(value = "SELECT c.idCliente, c.nombre, c.apellido,c.direccion, c.telefono  " +
            "FROM Cliente c " +
            "INNER JOIN Prestamos p " +
            "ON c.idCliente = p.fkCliente.idCliente " +
            "WHERE p.idPrestamo = :id")
    public List<String> clienteByIdPrestamo(Long id);

}
