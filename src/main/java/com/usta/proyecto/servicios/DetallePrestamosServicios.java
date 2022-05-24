package com.usta.proyecto.servicios;

import com.usta.proyecto.model.DetallePrestamos;
import com.usta.proyecto.repositorio.DetallePrestamosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePrestamosServicios {
    @Autowired
    private DetallePrestamosRepositorio detallePrestamosRepositorio;


    public List<DetallePrestamos> getAllDetallePrestamos() {

        return detallePrestamosRepositorio.findAll();
    }

    public DetallePrestamos crearDetallePrestamos(DetallePrestamos detallePrestamos) {
        return detallePrestamosRepositorio.save(detallePrestamos);
    }


    public void deleteById(Long id) {
        detallePrestamosRepositorio.deleteById(id);
    }

    //Metodos especificos
    public Integer countTotalDetallePrestamos() {
        return detallePrestamosRepositorio.countTotalDetallePrestamos();
    }
}
