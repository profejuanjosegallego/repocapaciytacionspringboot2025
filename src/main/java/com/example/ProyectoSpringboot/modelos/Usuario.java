package com.example.ProyectoSpringboot.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String nombres;
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    private String telefono;
    @Column(name = "city", length = 30)
    private String ciudad;

    public Usuario() {
    }

    public Usuario(Integer id, String nombres, LocalDate fechaNacimiento,
                   String correoElectronico, String telefono, String ciudad) {
        this.id = id;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
