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
    List<Estudiante> estudiante = null; 

    @PersistenceContext(unitName = "decanatoUes_CursoUes_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }
    
    //Verificar si un estudiante existe en la base de datos
    public Estudiante FindByCarnetExistente(String carnet){
         try {
            Query consulta = em.createNamedQuery("Estudiante.findByCarnet");
            consulta.setParameter("carnet", carnet);
            estudiante = consulta.getResultList();
            if (!estudiante.isEmpty() && estudiante != null) {
                return estudiante.get(0);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return null;
    }   
    
    //  Verificar si el estudiante ya esta inscripto al curso
    public Boolean EstudianteInscripto(int idcurso, String carnet){
    try {
            Query consulta = em.createNamedQuery("Estudiante.findCursoByidCursoAndCarnet");
            consulta.setParameter("idcurso", idcurso);
            consulta.setParameter("carnet", carnet);
            estudiante = consulta.getResultList();
            if (!estudiante.isEmpty() && estudiante != null) {
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return false;
    }
    
    // Cantidad de usuarios escritos
    public int EstudiantesCount(int idcurso){
       int inscriptos;
        try {
            Query consulta = em.createNamedQuery("Estudiante.findCountByIdCurso");
            consulta.setParameter("idcurso", idcurso);
             inscriptos = Integer.parseInt(""+consulta.getSingleResult());
            if (!estudiante.isEmpty() && estudiante != null) {
                return inscriptos;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return 0;
    }
    
    
}
