package com.usta.proyecto.servicios;

import com.usta.proyecto.model.Libro;
import com.usta.proyecto.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicios {
    @Autowired
    private LibroRepositorio libroRepositorio;


    public List<Libro> getAllLibro() {

        return libroRepositorio.findAll();
    }

    public Libro crearLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }


    public void deleteById(Long id) {
        libroRepositorio.deleteById(id);
    }

    //Metodos especificos
    public Integer countTotalLibro() {
        return libroRepositorio.countTotalLibros();
    }

    public List<String>cargarLibroByIdDetallePrestamos(Long id) {
        return libroRepositorio.LibroByIdDetallePrestamo(id);
    }
}
