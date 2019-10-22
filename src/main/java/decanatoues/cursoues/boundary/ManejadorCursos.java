/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.boundary;

import decanatoues.cursoues.controller.CursoFacade;
import decanatoues.cursoues.entity.Curso;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author gochez
 */
@Named
@ViewScoped
public class ManejadorCursos implements Serializable{

    @Inject
    private CursoFacade cursofd;
    
    private Curso curso;

    public ManejadorCursos() {
        this.curso= new Curso();
        
    }
    
    
    public void crearcurso(){
        try {
            System.out.println("entro al métodoOOOOOOOOO");
            this.curso.setCodigoCurso("cursoUes1");
            cursofd.create(curso);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro con exito"));
        } catch (Exception e) {
        }
    
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
    
}
