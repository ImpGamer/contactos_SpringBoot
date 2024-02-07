package com.imp.contactos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20,nullable = false)
    @NotBlank(message = "Debe ingresar un nombre")
    private String nombre;
    @Column(length = 10,nullable = false)
    @NotBlank(message = "Debe ingresar un telefono valido")
    private String telefono;
    @Column(length = 50,nullable = false)
    @NotEmpty(message = "Debe agregar un correo electronico")
    @Email
    private String email;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @Past(message = "Debe ser una fecha pasada")
    @NotNull(message = "Debe ingresar fecha de nacimiento")
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaRegistro;
    @PrePersist
    public void asignarFechaActual() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "Debe ingresar un telefono valido") String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}