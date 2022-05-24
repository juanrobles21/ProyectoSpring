package com.usta.proyecto.rest;

import com.usta.proyecto.model.Autor;
import com.usta.proyecto.servicios.AutorServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Autor/")
public class AutorRest {
    @Autowired // Le dice al programa que existe una entidad, un repo y un servicio
    private AutorServicios autorServicios;

    @GetMapping("Listar")//ruta personalizada
    private ResponseEntity<List<Autor>> listarTodasAutores() {
        return ResponseEntity.ok(autorServicios.getAllAutor());
    }

    @PostMapping("Crear")
    private ResponseEntity<Autor> guardarAutor(@RequestBody Autor autor) {
        Autor temporal = autorServicios.crearAutor(autor);
        try {
            return ResponseEntity.created(new URI("/api/Autor/" + temporal.getIdAutor())).body(autor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("Eliminar/{id}")
    private ResponseEntity<String> eliminarAutor(@PathVariable("id") Long id) {
        autorServicios.deleteById(id);
        return ResponseEntity.ok("Autor Eliminado con exito");
    }

    @PutMapping("Editar")
    private ResponseEntity<Autor> editarAutor(@RequestBody Autor autor) {
        Autor temporal = autorServicios.crearAutor(autor);
        try {
            return ResponseEntity.created(new URI("/api/Autor/" + temporal.getIdAutor())).body(autor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "Contar")
    private ResponseEntity<String> contarAutor() {
        return ResponseEntity.ok("El total de autores es: " + String.valueOf(autorServicios.countTotalAutor()));
    }

}
