/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.tekz.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author josef
 */
@Entity
public class Llamada {
    
    private int id;
    private Usuario usuario;
    private int telefono;
    private int duracion;
    private Date fecha;

    public Llamada() {
    }

    public Llamada(int id, Usuario usuario, int telefono, int duracion, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.telefono = telefono;
        this.duracion = duracion;
        this.fecha = fecha;
    }
  
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
 
}
