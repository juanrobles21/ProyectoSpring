package com.usta.proyecto.servicios;

import com.usta.proyecto.model.Cliente;
import com.usta.proyecto.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicios {
    @Autowired
    private ClienteRepositorio clienteRepositorio;


    public List<Cliente> getAllCliente() {

        return clienteRepositorio.findAll();
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepositorio.deleteById(id);
    }

    //Metodos especificos
    public Integer countTotalCliente() {
        return clienteRepositorio.countTotalCliente();
    }

    public List<String>cargarClienteByIdPrestamo(Long id) {
        return clienteRepositorio.clienteByIdPrestamo(id);
    }
}
