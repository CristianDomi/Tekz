/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.tekz.interfaces;

import java.util.List;
import mx.itson.tekz.entidades.Llamada;
import mx.itson.tekz.entidades.Usuario;

/**
 *
 * @author Cristian
 */
public interface CRUDllamada {
   
    /**
     * Agrega una llamada bajo los siguientes parametros
     * @param usuario Usuario usuario
     * @param telefono String telefono
     * @param duracion String duracion
     * @param fecha String fecha
     */
    public void Agregar(Usuario usuario, String telefono, String duracion, String fecha);
    
    /**
     * Regresa una lista de llamadas
     * @return 
     */
    public List Obtener();
    
    /**
     * Edita una llamada bajo el siguiente parametro
     * @param llamada Llamada llamada
     */
    public void Editar(Llamada llamada);
    
    /**
     * Elimina una llamada bajo el siguiente parametro
     * @param llamada  Llamada llamada
     */
    public void Eliminar(Llamada llamada);
    
}
