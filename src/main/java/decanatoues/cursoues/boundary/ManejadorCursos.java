/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.boundary;

import decanatoues.cursoues.controller.CarreraFacade;
import decanatoues.cursoues.controller.CursoEstudianteFacade;
import decanatoues.cursoues.controller.CursoFacade;
import decanatoues.cursoues.controller.DepartamentoFacade;
import decanatoues.cursoues.controller.EstudianteFacade;
import decanatoues.cursoues.cookie.CookieInstance;
import decanatoues.cursoues.entity.Carrera;
import decanatoues.cursoues.entity.Curso;
import decanatoues.cursoues.entity.CursoEstudiante;
import decanatoues.cursoues.entity.Departamento;
import decanatoues.cursoues.entity.Estudiante;
import decanatoues.cursoues.mail.MailService;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
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

    @Inject
    private CursoEstudianteFacade cef;

    @Inject
    private EstudianteFacade ef;

    @Inject
    private DepartamentoFacade df;

    @Inject
    private CarreraFacade cf;

    private Curso curso;
    private Curso cursoseleccionado;
    private List<Curso> listaCursos, listaCursoArchivado;
    private List<Estudiante> estudiantesCurso;
    private Date fechaInicio, fechaFinal;
    private CursoEstudiante cursoEstudiante;
    private Estudiante estudiante, fake;
    private int idDepartamento = 0, idCarrera = 1, idCurso;
    private String genero = "true";
    private Carrera carrera;
    ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
    private MailService mail;

    public ManejadorCursos() {
        this.curso = new Curso();
        this.cursoseleccionado = new Curso();
        this.estudiante = new Estudiante();
        this.fake = new Estudiante();
        this.cursoEstudiante = new CursoEstudiante();
    }

    @PostConstruct
    public void init() {
        listaCursos = cursofd.findActivo();
        listaCursoArchivado = cursofd.findArchivados();
        estudiantesCurso = cursofd.findbyCursoEStudiante(46);
    }

    public void llenarLista() {
        idCurso = curso.getIdCurso();
    }

    public void crearcurso() {
        try {
            boolean exito, exitoCreacion;
            this.curso.setCodigoCurso("cursoUes1");
            //validar fecha 
            fechaInicio = curso.getFechaInicio();
            exito = fechaInicio.before(curso.getFechaFin());
            if (curso.getCupo() == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Cupo debe ser mayor a cero"));
            } else if (exito == true || curso.getFechaInicio().equals(curso.getFechaFin())) {
                curso.setEstado(true);
                exitoCreacion = cursofd.crear(curso);
                if (exitoCreacion == true) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro con exito"));
                    //reset los componentes
                    curso.setNombreCurso("");
                    curso.setFechaInicio(null);
                    curso.setFechaFin(null);
                    curso.setDescripcion("");
                    curso.setCupo(0);
                    try {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("principal.jsf");
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

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
            boolean exito, exitoModificacion;
            fechaInicio = curso.getFechaInicio();
            exito = fechaInicio.equals(curso.getFechaFin());
            if (fechaInicio.equals(curso.getFechaFin()) || curso.getFechaInicio().before(curso.getFechaFin())) {
                exitoModificacion = cursofd.editar(curso);
                if (exitoModificacion == true) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Edición con exito"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Fallo al Editar"));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Fechas incorrectas"));
            }
            System.out.println("entro al métodoOOOOOOOOO");

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
            try {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Curso Archivado"));

                FacesContext.getCurrentInstance().getExternalContext().redirect("principal.jsf");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw e;

        }
    }

    public void reactivarCurso() {
        try {
            curso.setEstado(true);
            cursofd.edit(curso);
            try {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Curso Archivado"));

                FacesContext.getCurrentInstance().getExternalContext().redirect("principal.jsf");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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

    public List<Curso> getListaCursoArchivado() {
        return listaCursoArchivado;
    }

    public void setListaCursoArchivado(List<Curso> listaCursoArchivado) {
        this.listaCursoArchivado = listaCursoArchivado;
    }

    public Curso getCursoseleccionado() {
        return cursoseleccionado;
    }

    public void setCursoseleccionado(Curso cursoseleccionado) {
        this.cursoseleccionado = cursoseleccionado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Departamento> llenarDepartamentos() {
        List<Departamento> lista = df.findAll();
        return lista;
    }

    public List<Carrera> llenarCarreras() {
        List<Carrera> lista = cf.findByIdDepartamento(idDepartamento);
        return lista;
    }

    public void agregaEstudiante() {
        if (ef.EstudiantesCount(curso.getIdCurso()) < curso.getCupo()) {
            try {
                boolean exito;
                estudiante.setIdCarreraFk(cf.find(idCarrera));
                estudiante.setCorreoEstudiante(estudiante.getCarnet() + "@ues.edu.sv");
                Estudiante estudianteExistente = ef.FindByCarnetExistente(estudiante.getCarnet());
                if (estudianteExistente != null) {
                    AgregarAlcurso(estudianteExistente);
                } else {
                    exito = ef.crear(estudiante);
                    if (exito) {
                        AgregarAlcurso(estudiante);
                    } else {

                    }
                }
                System.out.println("entro al método para agregar");
            } catch (Exception ex) {
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Ya no hay cupos disponibles"));
        }
    }

    public void AgregarAlcurso(Estudiante est) {
        mail = new MailService();
        if (!(ef.EstudianteInscripto(curso.getIdCurso(), est.getCarnet()))) {
            cursoEstudiante.setIdEstudianteFk(est);
            cursoEstudiante.setIdCursosFk(curso);
            cursoEstudiante.setEstadoCursoEstudiante(true);
            cef.crear(cursoEstudiante);
            mail.enviaMensaje(est, curso);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Curso Estudiante agregado"));
            //reset los componentes
            estudiante.setNombreEstudiante("");
            estudiante.setApellidoEstudiante("");
            estudiante.setCorreoEstudiante("");
            estudiante.setCarnet("");
            estudiante.setSexo(true);
            try {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Estudiante inscrito"));

                FacesContext.getCurrentInstance().getExternalContext().redirect("principal.jsf");
            } catch (IOException ex) {
                Logger.getLogger(CookieInstance.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "El Carnet ya esta registrado en este curso"));
        }
    }

    public void buttonAction() {
        addMessage("Welcome to Primefaces!!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Estudiante> getEstudiantesCurso() {
        return estudiantesCurso;
    }

    public void setEstudiantesCurso(List<Estudiante> estudiantesCurso) {
        this.estudiantesCurso = estudiantesCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

}
