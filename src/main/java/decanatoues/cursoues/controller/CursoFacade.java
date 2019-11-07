/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.controller;

import decanatoues.cursoues.entity.Curso;
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
public class CursoFacade extends AbstractFacade<Curso> {

    List<Curso> cursos = null;

    @PersistenceContext(unitName = "decanatoUes_CursoUes_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursoFacade() {
        super(Curso.class);
    }

    public List<Curso> findActivo() {
        try {
            Query consulta = em.createNamedQuery("Curso.findByEstado");
            consulta.setParameter("estado", true);
            cursos = consulta.getResultList();
            if (!cursos.isEmpty() && cursos != null) {
                return cursos;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return cursos;
    }

    public Curso findByIdCurso(int id) {
        Curso cursoSeleccionado = null;
        try {
            //invocar a la consulta para poder buscar el objeto por su id
            Query query = em.createNamedQuery("Curso.findByIdCurso");
            query.setParameter("idCurso", id);
            List<Curso> cursos = query.getResultList();
            cursoSeleccionado = cursos.get(0);
        } catch (Exception e) {
        }
        return cursoSeleccionado;

    }

    public List<Estudiante> findbyCursoEStudiante(int id) {
        try {
            Query query = em.createNamedQuery("Curso.findByCursoEstudiante");
            query.setParameter("idCursoEstudiante", id);
            List<Estudiante> CursoEstudiante = query.getResultList();
            if (!CursoEstudiante.isEmpty()) {
                return CursoEstudiante;
            }
        } catch (Exception e) {
        }

        return null;
    }

}
