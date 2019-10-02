/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "carrera", catalog = "cursos", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c")
    , @NamedQuery(name = "Carrera.findByIdCarrera", query = "SELECT c FROM Carrera c WHERE c.idCarrera = :idCarrera")
    , @NamedQuery(name = "Carrera.findByNombreCarrera", query = "SELECT c FROM Carrera c WHERE c.nombreCarrera = :nombreCarrera")
    , @NamedQuery(name = "Carrera.findByCodigoCarrera", query = "SELECT c FROM Carrera c WHERE c.codigoCarrera = :codigoCarrera")})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrera", nullable = false)
    private Integer idCarrera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "nombre_carrera", nullable = false, length = 75)
    private String nombreCarrera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "codigo_carrera", nullable = false, length = 15)
    private String codigoCarrera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarreraFk")
    private List<Estudiante> estudianteList;
    @JoinColumn(name = "id_departamento_fk", referencedColumnName = "id_departamento", nullable = false)
    @ManyToOne(optional = false)
    private Departamento idDepartamentoFk;

    public Carrera() {
    }

    public Carrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Carrera(Integer idCarrera, String nombreCarrera, String codigoCarrera) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.codigoCarrera = codigoCarrera;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    public Departamento getIdDepartamentoFk() {
        return idDepartamentoFk;
    }

    public void setIdDepartamentoFk(Departamento idDepartamentoFk) {
        this.idDepartamentoFk = idDepartamentoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrera != null ? idCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.idCarrera == null && other.idCarrera != null) || (this.idCarrera != null && !this.idCarrera.equals(other.idCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "decanatoues.cursoues.entity.Carrera[ idCarrera=" + idCarrera + " ]";
    }
    
}
