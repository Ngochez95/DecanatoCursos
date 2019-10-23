/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.boundary;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import decanatoues.cursoues.controller.CursoFacade;
import decanatoues.cursoues.entity.Curso;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javafx.scene.chart.PieChart;
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
    private Date fechaInicio, fechaFinal;

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
            boolean exito, exitoCreacion;
            System.out.println("entro al métodoOOOOOOOOO");
            this.curso.setCodigoCurso("cursoUes1");
            //validar fecha 
            fechaInicio = curso.getFechaInicio();
            exito = fechaInicio.before(curso.getFechaFin());
            if (exito == true) {
                exitoCreacion = cursofd.crear(curso);
                if (exitoCreacion == true) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro con exito"));
                       //reset los componentes
                    curso.setNombreCurso("");
                    curso.setFechaInicio(null);
                    curso.setFechaFin(null);
                    curso.setDescripcion("");
                    curso.setCupo(0);
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Registo a fallado"));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Fechas incorrectas"));
            }
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
        int CursoSeleccionado = 0;
        //control de exito al momento de archivar el curso
        boolean exito;
        Curso cursoArchivar = cursofd.findByIdCurso(CursoSeleccionado);
        if (cursoArchivar != null) {
            cursoArchivar.setEstado(false);
            //usa modificar para realizar un eliminado suave
            exito = cursofd.editar(curso);
            if (exito == true) {
                System.out.println("Archivado con exito");
            } else {
                System.out.println("Fallo al achivar");
            }
        } else {
            System.out.println("Curso No encontrado");
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
