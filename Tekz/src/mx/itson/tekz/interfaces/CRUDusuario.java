/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.tekz.interfaces;

import java.util.List;
import mx.itson.tekz.entidades.Usuario;

/**
 *
 * @author Cristian
 */
public interface CRUDusuario {
    /**Agrega usuario bajo los siguientes parametros
     * 
     * @param numeroDeCuenta int numerodDeCuenta
     * @param nombre String nombre
     * @param apellido String apellido
     * @param direccion String direccion
     * @param estado String estado
     * @param ciudad String ciudad
     * @param telefono String telefono
     */
    public void Agregar(int numeroDeCuenta,String nombre,String apellido, String direccion, String estado, String ciudad, String telefono);
    /**
     * Regresa una lista de usuarios
     * @return 
     */
    public List Obtener();
    /**
     * Edita un usuario bajo el parametro
     * @param usuario Usuario usuario
     */
    public void Editar(Usuario usuario);
     /**
    * Elimina un usuario bajo el parametro
    * @param usuario Usuario usuario 
    */
    public void Eliminar(Usuario usuario);
    
    
}
