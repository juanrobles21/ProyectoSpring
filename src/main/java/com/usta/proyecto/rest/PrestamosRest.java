package com.usta.proyecto.rest;

import com.usta.proyecto.model.Prestamos;
import com.usta.proyecto.servicios.PrestamosServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Prestamos/")
public class PrestamosRest {
    @Autowired // Le dice al programa que existe una entidad, un repo y un servicio
    private PrestamosServicios prestamosServicios;

    @GetMapping("Listar")//ruta personalizada
    private ResponseEntity<List<Prestamos>> listarTodasPrestamos() {
        return ResponseEntity.ok(prestamosServicios.getAllPrestamos());
    }

    @PostMapping("Crear")
    private ResponseEntity<Prestamos> guardarPrestamos(@RequestBody Prestamos prestamos) {
        Prestamos temporal = prestamosServicios.crearPrestamos(prestamos);
        try {
            return ResponseEntity.created(new URI("/api/Prestamos/" + temporal.getIdPrestamo())).body(prestamos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("Eliminar/{id}")
    private ResponseEntity<String> eliminarPrestamos(@PathVariable("id") Long id) {
        prestamosServicios.deleteById(id);
        return ResponseEntity.ok("Prestamo eliminado con exito");
    }

    @PutMapping("Editar")
    private ResponseEntity<Prestamos> editarPrestamos(@RequestBody Prestamos prestamos) {
        Prestamos temporal = prestamosServicios.crearPrestamos(prestamos);
        try {
            return ResponseEntity.created(new URI("/api/Prestamos/" + temporal.getIdPrestamo())).body(prestamos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "Contar")
    private ResponseEntity<String> contarPrestamos() {
        return ResponseEntity.ok("El total de prestamos es: "+String.valueOf(prestamosServicios.countTotalPrestamos()));
    }

}
