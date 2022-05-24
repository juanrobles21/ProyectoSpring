package com.usta.proyecto.servicios;

import com.usta.proyecto.model.Editorial;
import com.usta.proyecto.repositorio.EditorialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialServicios {
    @Autowired
    private EditorialRepositorio editorialRepositorio;


    public List<Editorial> getAllEditorial() {

        return editorialRepositorio.findAll();
    }

    public Editorial crearEditorial(Editorial editorial) {
        return editorialRepositorio.save(editorial);
    }


    public void deleteById(Long id) {
        editorialRepositorio.deleteById(id);
    }

    //Metodos especificos
    public Integer countTotalEditorial() {
        return editorialRepositorio.countTotalEditorial();
    }

    public List<String>cargarEditorialByIdLibro(Long id) {
        return editorialRepositorio.editorialByIdLibro(id);
    }

}
