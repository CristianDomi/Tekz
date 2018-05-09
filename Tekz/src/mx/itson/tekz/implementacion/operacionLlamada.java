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
import mx.itson.tekz.entidades.Llamada;
import mx.itson.tekz.entidades.Usuario;
import mx.itson.tekz.interfaces.CRUDllamada;
import org.hibernate.Session;

/**
 *
 * @author Cristian
 */
public class operacionLlamada implements CRUDllamada{
/**Agrega una llamada a la tabla llamada de la base de datos
 * 
 * @param usuario - Usuario al que se le asignara la llamada
 * @param telefono - Telefono que recibe la llamada
 * @param duracion - Duracion de la llamada
 * @param fecha  - Fecha de la llamada
 */
    @Override
    public void Agregar(Usuario usuario, String telefono, String duracion, String fecha) {
        Llamada l = new Llamada();
        try {
            l.setUsuario(usuario);
            l.setTelefono(telefono);
            l.setDuracion(duracion);
            l.setFecha(fecha);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(l);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al intentar guardar");
        }
    }

    /**
     * Regrea una lista de llamadas
     * 
     * @return 
     */
    @Override
    public List Obtener() {
        List<Llamada> llamadas = new ArrayList<Llamada>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Llamada> criteria = builder.createQuery(Llamada.class);
            criteria.from(Llamada.class);
            llamadas = session.createQuery(criteria).getResultList();
        } catch (Exception ex){
            System.out.println("Ocurrió un error al intentar obtener registros de Llamada");
        }
        return llamadas;
    }
/**
 * Edita una llamada de la tabla llamada de la base de datos
 * 
 * @param llamada - Llamada a editar
 */
    @Override
    public void Editar(Llamada llamada) {
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(llamada);
        session.getTransaction().commit();
        session.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al intentar actualizar we :S");
        }    }

    /**
     * Elimina una llamada de la base de datos
     * 
     * @param llamada - Llamada a eliminar
     */
    @Override
    public void Eliminar(Llamada llamada) {
       try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(llamada);
        session.getTransaction().commit();
        session.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al intentar borrar ");
        }    }
    
}
