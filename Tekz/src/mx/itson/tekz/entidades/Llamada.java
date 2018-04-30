/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.tekz.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

/**
 *
 * @author josef
 */
public class Llamada {
    private Usuario usuario;
    private int telefono;
    private int duracion;
    private Date fecha;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public List<Llamada> obtenerTodos(){
        List<Llamada> llamadas = new ArrayList<Llamada>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Llamada> criteria = builder.createQuery(Llamada.class);
            criteria.from(Llamada.class);
            llamadas = session.createQuery(criteria).getResultList();
//            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//            for (Compania c : companias) {
//      model.addRow(new Object[]{ c.nombre});
//            }
        } catch (Exception ex){
            System.out.println("Ocurrió un error al intentar obtener registros de Compañia xdd");
        }
        return llamadas;
    }
}
