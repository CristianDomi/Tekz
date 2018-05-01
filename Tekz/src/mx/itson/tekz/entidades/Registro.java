/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.tekz.entidades;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Cristian
 */
@Entity
public class Registro {
    
    int id;
    String persona;
    List <Llamada> llamadas;

    public Registro() {
    }

    public Registro(int id, String persona, List<Llamada> llamadas) {
        this.id = id;
        this.persona = persona;
        this.llamadas = llamadas;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }
    
   @ManyToMany(cascade ={ CascadeType.ALL})
    @JoinTable(
    name ="relregistrollamada",
    joinColumns = { @JoinColumn (name="idRegistro")},
    inverseJoinColumns = { @JoinColumn(name="idLlamada") }         
    )
    public List<Llamada> getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(List<Llamada> llamadas) {
        this.llamadas = llamadas;
    }
    
    
    
    
}
