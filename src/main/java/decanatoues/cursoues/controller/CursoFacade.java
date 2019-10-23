/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.controller;

import decanatoues.cursoues.entity.Curso;
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

    @PersistenceContext(unitName = "decanatoUes_CursoUes_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursoFacade() {
        super(Curso.class);
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

}
