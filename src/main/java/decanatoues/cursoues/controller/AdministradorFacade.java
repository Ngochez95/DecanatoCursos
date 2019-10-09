/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.controller;

import decanatoues.cursoues.entity.Administrador;
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
public class AdministradorFacade extends AbstractFacade<Administrador> {

    @PersistenceContext(unitName = "decanatoUes_CursoUes_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministradorFacade() {
        super(Administrador.class);
    }

    public Administrador autenticar(Administrador user) {
        Administrador usuario= null;
        try {
            Query query = em.createNamedQuery("Administrador.Autenticar");
            query.setParameter("usuario", user.getNombreUsuario());
            query.setParameter("contrasenia", user.getContrasenia());
            
            List<Administrador> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
            
        } catch (Exception e) {
        }
        return usuario;

    }

}
