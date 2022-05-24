package com.usta.proyecto.rest;

import com.usta.proyecto.model.Editorial;
import com.usta.proyecto.servicios.EditorialServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Editorial/")
public class EditorialRest {
    @Autowired // Le dice al programa que existe una entidad, un repo y un servicio
    private EditorialServicios editorialServicios;

    @GetMapping("Listar")//ruta personalizada
    private ResponseEntity<List<Editorial>> listarTodasEditorial() {
        return ResponseEntity.ok(editorialServicios.getAllEditorial());
    }

    @PostMapping("Crear")
    private ResponseEntity<Editorial> guardarEditorial(@RequestBody Editorial editorial) {
        Editorial temporal = editorialServicios.crearEditorial(editorial);
        try {
            return ResponseEntity.created(new URI("/api/Editorial/" + temporal.getIdEditorial())).body(editorial);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("Eliminar/{id}")
    private ResponseEntity<String> eliminarEditorial(@PathVariable("id") Long id) {
        editorialServicios.deleteById(id);
        return ResponseEntity.ok("Editorial eliminada con exito");
    }

    @PutMapping("Editar")
    private ResponseEntity<Editorial> editarEditorial(@RequestBody Editorial editorial) {
        Editorial temporal = editorialServicios.crearEditorial(editorial);
        try {
            return ResponseEntity.created(new URI("/api/Editorial/" + temporal.getIdEditorial())).body(editorial);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "Contar")
    private ResponseEntity<String> contarEditorial() {
        return ResponseEntity.ok("El total de editoliales es: " + String.valueOf(editorialServicios.countTotalEditorial()));
    }

    @GetMapping(value = "Cargar/{id}")
    private ResponseEntity<List<String>> cargarEditorialByIdLibro(@PathVariable("id") Long id) {
        return ResponseEntity.ok(editorialServicios.cargarEditorialByIdLibro(id));

    }

}
