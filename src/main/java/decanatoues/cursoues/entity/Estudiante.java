/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gochez
 */
@Entity
@Table(name = "estudiante", catalog = "cursos", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByIdEstudiante", query = "SELECT e FROM Estudiante e WHERE e.idEstudiante = :idEstudiante")
    , @NamedQuery(name = "Estudiante.findByNombreEstudiante", query = "SELECT e FROM Estudiante e WHERE e.nombreEstudiante = :nombreEstudiante")
    , @NamedQuery(name = "Estudiante.findByApellidoEstudiante", query = "SELECT e FROM Estudiante e WHERE e.apellidoEstudiante = :apellidoEstudiante")
    , @NamedQuery(name = "Estudiante.findByCarnet", query = "SELECT e FROM Estudiante e WHERE e.carnet = :carnet")
    , @NamedQuery(name = "Estudiante.findBySexo", query = "SELECT e FROM Estudiante e WHERE e.sexo = :sexo")
    , @NamedQuery(name = "Estudiante.findByCorreoEstudiante", query = "SELECT e FROM Estudiante e WHERE e.correoEstudiante = :correoEstudiante")
    ,@NamedQuery(name = "Estudiante.findCountByIdCurso", query = "SELECT  count(e) from Estudiante as e join e.cursoEstudianteList as cel join cel.idCursosFk as idc where idc.idCurso= :idcurso")
    ,@NamedQuery(name = "Estudiante.findCursoByidCursoAndCarnet", query = "SELECT e from Estudiante as e join e.cursoEstudianteList as ces join ces.idCursosFk as idc where idc.idCurso=:idcurso and e.carnet=:carnet")
    , @NamedQuery(name = "Estudiante.findByDepartamento", query = "SELECT e FROM Estudiante e WHERE e.idCarreraFk.idDepartamentoFk.idDepartamento= :id")
    , @NamedQuery(name = "Estudiante.findByCorreoEstudiante", query = "SELECT e FROM Estudiante e WHERE e.correoEstudiante = :correoEstudiante")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudiante", nullable = false)
    private Integer idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "nombre_estudiante", nullable = false, length = 75)
    private String nombreEstudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "apellido_estudiante", nullable = false, length = 75)
    private String apellidoEstudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "carnet", nullable = false, length = 7)
    private String carnet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo", nullable = false)
    private boolean sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo_estudiante", nullable = false, length = 100)
    private String correoEstudiante;
    @JoinColumn(name = "id_carrera_fk", referencedColumnName = "id_carrera", nullable = false)
    @ManyToOne(optional = false)
    private Carrera idCarreraFk;
    @OneToMany(mappedBy = "idEstudianteFk")
    private List<CursoEstudiante> cursoEstudianteList;

    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiante(Integer idEstudiante, String nombreEstudiante, String apellidoEstudiante, String carnet, boolean sexo, String correoEstudiante) {
        this.idEstudiante = idEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoEstudiante = apellidoEstudiante;
        this.carnet = carnet;
        this.sexo = sexo;
        this.correoEstudiante = correoEstudiante;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getCorreoEstudiante() {
        return correoEstudiante;
    }

    public void setCorreoEstudiante(String correoEstudiante) {
        this.correoEstudiante = correoEstudiante;
    }

    public Carrera getIdCarreraFk() {
        return idCarreraFk;
    }

    public void setIdCarreraFk(Carrera idCarreraFk) {
        this.idCarreraFk = idCarreraFk;
    }

    @XmlTransient
    public List<CursoEstudiante> getCursoEstudianteList() {
        return cursoEstudianteList;
    }

    public void setCursoEstudianteList(List<CursoEstudiante> cursoEstudianteList) {
        this.cursoEstudianteList = cursoEstudianteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiante != null ? idEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.idEstudiante == null && other.idEstudiante != null) || (this.idEstudiante != null && !this.idEstudiante.equals(other.idEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "decanatoues.cursoues.entity.Estudiante[ idEstudiante=" + idEstudiante + " ]";
    }

}
