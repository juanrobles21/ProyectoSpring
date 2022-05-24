package com.usta.proyecto.rest;

import com.usta.proyecto.model.AutoresLibro;
import com.usta.proyecto.servicios.AutoresLibroServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/AutoresLibro/")
public class AutoresLibroRest {
    @Autowired // Le dice al programa que existe una entidad, un repo y un servicio
    private AutoresLibroServicios autoresLibroServicios;

    @GetMapping("Listar")//ruta personalizada
    private ResponseEntity<List<AutoresLibro>> listarTodasAutoresLibro() {
        return ResponseEntity.ok(autoresLibroServicios.getAllAutoresLibro());
    }

    @PostMapping("Crear")
    private ResponseEntity<AutoresLibro> guardarAutoresLibro(@RequestBody AutoresLibro autoresLibro) {
        AutoresLibro temporal = autoresLibroServicios.crearAutoresLibro(autoresLibro);
        try {
            return ResponseEntity.created(new URI("/api/AutoresLibro/" + temporal.getIdAutorLibro())).body(autoresLibro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("Eliminar/{id}")
    private ResponseEntity<String> eliminarAutoresLibro(@PathVariable("id") Long id) {
        autoresLibroServicios.deleteById(id);
        return ResponseEntity.ok("Autores libro elmininado con exito");
    }

    @PutMapping("Editar")
    private ResponseEntity<AutoresLibro> editarAutoresLibro(@RequestBody AutoresLibro autoresLibro) {
        AutoresLibro temporal = autoresLibroServicios.crearAutoresLibro(autoresLibro);
        try {
            return ResponseEntity.created(new URI("/api/AutoresLibro/" + temporal.getIdAutorLibro())).body(autoresLibro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "Contar")
    private ResponseEntity<String> contarAutoresLibro() {
        return ResponseEntity.ok("El total de autores cliente es: "+String.valueOf(autoresLibroServicios.countTotalAutoresLibro()));
    }

}
