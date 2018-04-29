/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.tekz.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author josef
 */
public class Usuario {
    private int numerodecuenta;
    private String nombre;
    private String apellido;
    private String direccion;
    private String estado;
    private String ciudad;
    private String telefono;

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
    
    public List<Usuario> obtenerTodos(){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
            criteria.from(Usuario.class);
            usuarios = session.createQuery(criteria).getResultList();
//            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//            for (Compania c : companias) {
//      model.addRow(new Object[]{ c.nombre});
//            }
        } catch (Exception ex){
            System.out.println("Ocurrió un error al intentar obtener registros de Compañia xdd");
        }
        return usuarios;
    }
}
