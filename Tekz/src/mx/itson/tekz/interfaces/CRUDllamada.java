/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.tekz.interfaces;

import java.util.Date;
import java.util.List;
import mx.itson.tekz.entidades.Llamada;
import mx.itson.tekz.entidades.Usuario;

/**
 *
 * @author Cristian
 */
public interface CRUDllamada {
   
    public void Agregar(Usuario usuario, int telefono, int duracion, Date fecha);
    public List Obtener();
    public void Editar(Llamada llamada);
    public void Eliminar(Llamada llamada);
    
}
