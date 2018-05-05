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
import mx.itson.tekz.entidades.Llamada;
import mx.itson.tekz.entidades.Registro;
import mx.itson.tekz.interfaces.CRUDregistro;
import mx.itson.tekz.persistencia.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Cristian
 */
public class operacionRegistro implements CRUDregistro{

    @Override
    public void Agregar(int numerocuenta , String persona) {
    
    List<Llamada> llamadas = new ArrayList<Llamada>();
    List<Registro> registros = new ArrayList<Registro>();
  
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Llamada> criteria = builder.createQuery(Llamada.class);
            criteria.from(Llamada.class);
            llamadas = session.createQuery(criteria).getResultList();
            
            CriteriaBuilder builder2 = session.getCriteriaBuilder();
            CriteriaQuery<Registro> criteria2 = builder2.createQuery(Registro.class);
            criteria2.from(Registro.class);
            registros = session.createQuery(criteria2).getResultList();
            for (Llamada l : llamadas) {
                if (l.getUsuario().getNumerodecuenta() == numerocuenta) {
                    for (Registro r : registros) {
                        if (r.getPersona().equals(persona)) {     
                            r.getLlamadas().add(l);
                            session.beginTransaction();
                            session.save(l);
                            session.getTransaction().commit();
                            session.close();

                        }
                    }
                }
            }
                                     
         } catch (Exception ex){
            System.out.println("Ocurrió un error al intentar obtener registros de Compañia xdd"); 
    }
    }

    @Override
    public List Obtener() {
       List<Registro> registros = new ArrayList<Registro>();
       try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Registro> criteria = builder.createQuery(Registro.class);
            criteria.from(Registro.class);
            registros = session.createQuery(criteria).getResultList();   
        } catch (Exception ex){
            System.out.println("Ocurrió un error al intentar obtener registros de Registro xdd");
        }
        return registros;    }

    @Override
    public void Editar(Registro registro) {
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(registro);
        session.getTransaction().commit();
        session.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al intentar actualizar we :S");
        }    }

    @Override
    public void Eliminar(Registro registro) {
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(registro);
        session.getTransaction().commit();
        session.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al intentar borrar we :S");
        }    }
    
}
