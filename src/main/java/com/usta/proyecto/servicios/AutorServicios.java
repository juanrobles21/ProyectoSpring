package com.usta.proyecto.servicios;

import com.usta.proyecto.model.Autor;
import com.usta.proyecto.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServicios {
    @Autowired
    private AutorRepositorio autorRepositorio;


    public List<Autor> getAllAutor() {

        return autorRepositorio.findAll();
    }

    public Autor crearAutor(Autor autor) {
        return autorRepositorio.save(autor);
    }


    public void deleteById(Long id) {
        autorRepositorio.deleteById(id);
    }

    //Metodos especificos
    public Integer countTotalAutor() {
        return autorRepositorio.countTotalAutor();
    }
}
