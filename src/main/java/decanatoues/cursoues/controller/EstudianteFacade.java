/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.controller;

import decanatoues.cursoues.entity.Estudiante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gochez
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> {

    @PersistenceContext(unitName = "decanatoUes_CursoUes_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }
    
    public List<Estudiante> findByGenero(boolean genero){
       List<Estudiante> lista= null;
        try {
            Query consulta = em.createNamedQuery("Estudiante.findBySexo");
            consulta.setParameter("sexo", genero);
            lista = consulta.getResultList();
            if (!lista.isEmpty() && lista!= null) {
                return lista;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return lista;
    }
    
    public List<Estudiante> findByDepartamento(int id){
       List<Estudiante> lista= null;
        try {
            Query consulta = em.createNamedQuery("Estudiante.findByDepartamento");
            consulta.setParameter("id", id);
            lista = consulta.getResultList();
            if (!lista.isEmpty() && lista!= null) {
                return lista;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return lista;
    }
    
}
