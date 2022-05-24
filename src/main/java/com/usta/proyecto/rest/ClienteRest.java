package com.usta.proyecto.rest;

import com.usta.proyecto.model.Cliente;
import com.usta.proyecto.servicios.ClienteServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cliente/")
public class ClienteRest {
    @Autowired // Le dice al programa que existe una entidad, un repo y un servicio
    private ClienteServicios clienteServicios;

    @GetMapping("Listar")//ruta personalizada
    private ResponseEntity<List<Cliente>> listarTodasCliente() {
        return ResponseEntity.ok(clienteServicios.getAllCliente());
    }

    @PostMapping("Crear")
    private ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
        Cliente temporal = clienteServicios.crearCliente(cliente);
        try {
            return ResponseEntity.created(new URI("/api/Cliente/" + temporal.getIdCliente())).body(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("Eliminar/{id}")
    private ResponseEntity<String> eliminarCliente(@PathVariable("id") Long id) {
        clienteServicios.deleteById(id);
        return ResponseEntity.ok("Cliente eliminado con exito");
    }

    @PutMapping("Editar")
    private ResponseEntity<Cliente> editarCliente(@RequestBody Cliente cliente) {
        Cliente temporal = clienteServicios.crearCliente(cliente);
        try {
            return ResponseEntity.created(new URI("/api/Cliente/" + temporal.getIdCliente())).body(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "Contar")
    private ResponseEntity<String> contarCliente() {
        return ResponseEntity.ok("El total de clientes es: " + String.valueOf(clienteServicios.countTotalCliente()));
    }

    @GetMapping(value = "Cargar/{id}")
    private ResponseEntity<List<String>> cargarClienteByIdPrestamo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clienteServicios.cargarClienteByIdPrestamo(id));

    }

}
