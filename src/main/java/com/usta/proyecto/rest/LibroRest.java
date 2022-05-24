package com.usta.proyecto.rest;

import com.usta.proyecto.model.Libro;
import com.usta.proyecto.servicios.LibroServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Libro/")
public class LibroRest {
    @Autowired // Le dice al programa que existe una entidad, un repo y un servicio
    private LibroServicios libroServicios;

    @GetMapping("Listar")//ruta personalizada
    private ResponseEntity<List<Libro>> listarTodasLibro() {
        return ResponseEntity.ok(libroServicios.getAllLibro());
    }

    @PostMapping("Crear")
    private ResponseEntity<Libro> guardarLibro(@RequestBody Libro libro) {
        Libro temporal = libroServicios.crearLibro(libro);
        try {
            return ResponseEntity.created(new URI("/api/Libro/" + temporal.getIdLibro())).body(libro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("Eliminar/{id}")
    private ResponseEntity<String> eliminarLibro(@PathVariable("id") Long id) {
        libroServicios.deleteById(id);
        return ResponseEntity.ok("Libro eliminado con exito");
    }

    @PutMapping("Editar")
    private ResponseEntity<Libro> editarLibro(@RequestBody Libro libro) {
        Libro temporal = libroServicios.crearLibro(libro);
        try {
            return ResponseEntity.created(new URI("/api/Libro/" + temporal.getIdLibro())).body(libro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "Contar")
    private ResponseEntity<String> contarLibro() {
        return ResponseEntity.ok("El total de libros es: " + String.valueOf(libroServicios.countTotalLibro()));
    }

    @GetMapping(value = "Cargar/{id}")
    private ResponseEntity<List<String>> cargarLibroByIdDetallePrestamo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(libroServicios.cargarLibroByIdDetallePrestamos(id));

    }

}
