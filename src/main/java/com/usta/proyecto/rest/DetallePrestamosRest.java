package com.usta.proyecto.rest;

import com.usta.proyecto.model.DetallePrestamos;
import com.usta.proyecto.servicios.DetallePrestamosServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/DetallePrestamos/")
public class DetallePrestamosRest {
    @Autowired // Le dice al programa que existe una entidad, un repo y un servicio
    private DetallePrestamosServicios detallePrestamosServicios;

    @GetMapping("Listar")//ruta personalizada
    private ResponseEntity<List<DetallePrestamos>> listarTodasDetallePrestamos() {
        return ResponseEntity.ok(detallePrestamosServicios.getAllDetallePrestamos());
    }

    @PostMapping("Crear")
    private ResponseEntity<DetallePrestamos> guardarDetallePrestamos(@RequestBody DetallePrestamos detallePrestamos) {
        DetallePrestamos temporal = detallePrestamosServicios.crearDetallePrestamos(detallePrestamos);
        try {
            return ResponseEntity.created(new URI("/api/DetallePrestamos/" + temporal.getIdDetallePrestamo())).body(detallePrestamos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("Eliminar/{id}")
    private ResponseEntity<String> eliminarDetallePrestamos(@PathVariable("id") Long id) {
        detallePrestamosServicios.deleteById(id);
        return ResponseEntity.ok("Detalle Prestamos eliminado con exito");
    }

    @PutMapping("Editar")
    private ResponseEntity<DetallePrestamos> editarDetallePrestamos(@RequestBody DetallePrestamos detallePrestamos) {
        DetallePrestamos temporal = detallePrestamosServicios.crearDetallePrestamos(detallePrestamos);
        try {
            return ResponseEntity.created(new URI("/api/DetallePrestamos/" + temporal.getIdDetallePrestamo())).body(detallePrestamos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "Contar")
    private ResponseEntity<String> contarDetallePrestamos() {
        return ResponseEntity.ok("El total de detalles prestamos es :" + String.valueOf(detallePrestamosServicios.countTotalDetallePrestamos()));
    }

}

