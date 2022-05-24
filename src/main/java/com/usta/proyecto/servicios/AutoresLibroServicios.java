package com.usta.proyecto.servicios;

import com.usta.proyecto.model.AutoresLibro;
import com.usta.proyecto.repositorio.AutoresLibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresLibroServicios {
    @Autowired
    private AutoresLibroRepositorio autoresLibroRepositorio;


    public List<AutoresLibro> getAllAutoresLibro() {

        return autoresLibroRepositorio.findAll();
    }

    public AutoresLibro crearAutoresLibro(AutoresLibro autoresLibro) {
        return autoresLibroRepositorio.save(autoresLibro);
    }


    public void deleteById(Long id) {
        autoresLibroRepositorio.deleteById(id);
    }

    //Metodos especificos
    public Integer countTotalAutoresLibro() {
        return autoresLibroRepositorio.countTotalAutoresLibro();
    }
}
