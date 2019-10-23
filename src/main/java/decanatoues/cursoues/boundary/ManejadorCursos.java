/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.boundary;

import decanatoues.cursoues.controller.CursoFacade;
import decanatoues.cursoues.entity.Curso;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author gochez
 */
@Named
@ViewScoped
public class ManejadorCursos implements Serializable {

    @Inject
    private CursoFacade cursofd;

    private Curso curso;
    private Curso cursoseleccionado;
    private List<Curso> listaCursos;

    public ManejadorCursos() {
        this.curso = new Curso();
        this.cursoseleccionado = new Curso();
    }

    @PostConstruct
    public void init() {
        listaCursos = cursofd.findActivo();

    }

    public void crearcurso() {
        try {
            System.out.println("entro al métodoOOOOOOOOO");
            this.curso.setCodigoCurso("cursoUes1");
            cursofd.create(curso);
            curso.setNombreCurso("");
            curso.setFechaInicio(null);
            curso.setFechaFin(null);
            curso.setDescripcion("");
            curso.setCupo(0);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro con exito"));
        } catch (Exception ex) {
        }

    }
    
        public void editarcurso() {
        try {
            System.out.println("entro al métodoOOOOOOOOO");
            cursofd.edit(curso);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Edición con exito"));
        } catch (Exception ex) {
        }

    }

     public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((Curso) event.getObject()).getIdCurso().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Curso) event.getObject()).getIdCurso().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //archivar los cursos que sean seleccionados 
    public void archivarCurso() {
        try {
            curso.setEstado(false);
            cursofd.edit(curso);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Curso Archivado"));
        } catch (Exception e) {
            throw e;
        }
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public Curso getCursoseleccionado() {
        return cursoseleccionado;
    }

    public void setCursoseleccionado(Curso cursoseleccionado) {
        this.cursoseleccionado = cursoseleccionado;
    }

}
