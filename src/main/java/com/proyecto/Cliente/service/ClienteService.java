package com.proyecto.Cliente.service;

import com.proyecto.Cliente.model.Cliente;
import com.proyecto.Cliente.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + id));
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente clienteDetalles) {
        Cliente cliente = obtenerClientePorId(id);
        cliente.setNombre(clienteDetalles.getNombre());
        cliente.setApellido(clienteDetalles.getApellido());
        cliente.setEmail(clienteDetalles.getEmail());
        cliente.setTelefono(clienteDetalles.getTelefono());
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        // Verificamos que el cliente exista antes de intentar eliminarlo
        Cliente cliente = obtenerClientePorId(id);
        clienteRepository.delete(cliente);
    }
}