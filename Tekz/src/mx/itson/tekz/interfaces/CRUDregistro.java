/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.tekz.interfaces;

import java.util.List;
import mx.itson.tekz.entidades.Registro;

/**
 *
 * @author Cristian
 */
public interface CRUDregistro {
 
    public void Agregar(int numerocuenta, String persona);
    public List Obtener();
    public void Editar(Registro registro);
    public void Eliminar(Registro registro);

    
}
