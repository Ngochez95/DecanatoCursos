/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.controller;

import decanatoues.cursoues.entity.Carrera;
import java.util.ArrayList;
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
public class CarreraFacade extends AbstractFacade<Carrera> {

    @PersistenceContext(unitName = "decanatoUes_CursoUes_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarreraFacade() {
        super(Carrera.class);
    }
    
    public List<Carrera> findByIdDepartamento(int idDepartamento){
        List<Carrera> lista = new ArrayList<>();
        try {
            Query consulta = em.createNamedQuery("Carrera.findByIdDepartamento");
            consulta.setParameter("idDepartamento", idDepartamento);
            lista = consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return lista;
    }
    
}
