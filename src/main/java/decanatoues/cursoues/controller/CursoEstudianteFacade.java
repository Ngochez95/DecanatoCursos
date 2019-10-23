/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.controller;

import decanatoues.cursoues.entity.Curso;
import decanatoues.cursoues.entity.CursoEstudiante;
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
public class CursoEstudianteFacade extends AbstractFacade<CursoEstudiante> {

    @PersistenceContext(unitName = "decanatoUes_CursoUes_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursoEstudianteFacade() {
        super(CursoEstudiante.class);
    }

}
