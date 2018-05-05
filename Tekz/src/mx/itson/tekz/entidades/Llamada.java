/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.tekz.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author josef
 */
@Entity
public class Llamada {
    
    private int id;
    private Usuario usuario;
    private String telefono;
    private String duracion;
    private String fecha;

    public Llamada() {
    }

    public Llamada(int id, Usuario usuario, String telefono, String duracion, String fecha) {
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
   	
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario")  
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
 
}
