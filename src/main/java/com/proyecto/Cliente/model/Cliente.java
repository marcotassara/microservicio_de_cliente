package com.proyecto.Cliente.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
    @Column(name = "IDCLIENTE")
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "APELLIDO", length = 100)
    private String apellido;

    @Column(name = "EMAIL", unique = true, length = 150)
    private String email;

    @Column(name = "TELEFONO", length = 20)
    private String telefono;
}
