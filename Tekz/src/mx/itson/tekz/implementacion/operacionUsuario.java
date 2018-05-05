/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.tekz.implementacion;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.tekz.persistencia.HibernateUtil;
import mx.itson.tekz.entidades.Usuario;
import org.hibernate.Session;
import mx.itson.tekz.interfaces.CRUDusuario;

/**
 *
 * @author Cristian
 */
public class operacionUsuario implements CRUDusuario {

    @Override
    public void Agregar(int numeroDeCuenta,String nombre,String apellido, String direccion, String estado, String ciudad, String telefono) {
     Usuario u = new Usuario();
        try {
            u.setNumerodecuenta(numeroDeCuenta);
            u.setNombre(nombre);
            u.setApellido(apellido);
            u.setDireccion(direccion);
            u.setEstado(estado);
            u.setCiudad(ciudad);
            u.setTelefono(telefono);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(u);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al intentar guardar");
        }
    }

    @Override
    public List Obtener() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
            criteria.from(Usuario.class);
            usuarios = session.createQuery(criteria).getResultList();
        } catch (Exception ex){
            System.out.println("Ocurrió un error al intentar obtener registros de Usuario");
        }
        return usuarios;           
    }
    

    @Override
    public void Editar(Usuario usuario) {
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
        session.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al intentar actualizar we :S");
        }    }

    @Override
    public void Eliminar(Usuario usuario) {
       try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction().commit();
        session.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al intentar borrar we :S");
        }    }
}
