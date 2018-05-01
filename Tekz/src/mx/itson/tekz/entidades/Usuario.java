/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.tekz.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author josef
 */
@Entity
public class Usuario {
    
    private int id;
    private int numerodecuenta;
    private String nombre;
    private String apellido;
    private String direccion;
    private String estado;
    private String ciudad;
    private String telefono;

    public Usuario() {
    }

    public Usuario(int id, int numerodecuenta, String nombre, String apellido, String direccion, String estado, String ciudad, String telefono) {
        this.id = id;
        this.numerodecuenta = numerodecuenta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.estado = estado;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumerodecuenta() {
        return numerodecuenta;
    }

    public void setNumerodecuenta(int numerodecuenta) {
        this.numerodecuenta = numerodecuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
