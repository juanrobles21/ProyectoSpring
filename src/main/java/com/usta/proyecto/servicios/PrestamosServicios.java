package com.usta.proyecto.servicios;

import com.usta.proyecto.model.Prestamos;
import com.usta.proyecto.repositorio.PrestamosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamosServicios {
    @Autowired
    private PrestamosRepositorio prestamosRepositorio;


    public List<Prestamos> getAllPrestamos() {

        return prestamosRepositorio.findAll();
    }

    public Prestamos crearPrestamos(Prestamos prestamos) {
        return prestamosRepositorio.save(prestamos);
    }


    public void deleteById(Long id) {
        prestamosRepositorio.deleteById(id);
    }

    //Metodos especificos
    public Integer countTotalPrestamos() {
        return prestamosRepositorio.countTotalPrestamos();
    }
}
