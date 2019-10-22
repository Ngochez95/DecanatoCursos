/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.boundary;

import decanatoues.cursoues.controller.CarreraFacade;
import decanatoues.cursoues.controller.CursoEstudianteFacade;
import decanatoues.cursoues.controller.DepartamentoFacade;
import decanatoues.cursoues.controller.EstudianteFacade;
import decanatoues.cursoues.entity.Carrera;
import decanatoues.cursoues.entity.CursoEstudiante;
import decanatoues.cursoues.entity.Departamento;
import decanatoues.cursoues.entity.Estudiante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author daredevil
 */
@Named
@ViewScoped
public class ManejadorInscripcion implements Serializable{
   
    @Inject
    private CursoEstudianteFacade cef;
    
    @Inject 
    private EstudianteFacade ef;
    
    @Inject
    private DepartamentoFacade df;
    
    @Inject
    private CarreraFacade cf;
    
    private CursoEstudiante cursoEstudiante;
    private Estudiante estudiante;
    private int idDepartamento=0;
    
    
    
    public Estudiante InscribirEstudiante(String nombre, String apellido, String carnet, int idCarrera, boolean sexo, String correo){
        //buscar carrera por su id
        Carrera carrera= new Carrera();
        
        Estudiante estudiante= new Estudiante();
        estudiante.setNombreEstudiante(nombre);
        estudiante.setApellidoEstudiante(apellido);
        estudiante.setCarnet(carnet);
        estudiante.setCorreoEstudiante(correo);
        estudiante.setSexo(sexo);
        estudiante.setIdCarreraFk(carrera);

        return estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    public List<Departamento> llenarDepartamentos(){
        List<Departamento> lista =df.findAll();
        return lista;
    }
    
    public List<Carrera> llenarCarreras(int idDepartamento){
        List<Carrera> lista= cf.findByIdDepartamento(idDepartamento);
        return lista;
    }
    
    
            
    
    
    
    
            
    
    
    
    
    
}
