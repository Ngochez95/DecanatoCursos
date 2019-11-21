/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gochez
 */
@Entity
@Table(name = "curso_estudiante", catalog = "cursos", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoEstudiante.findAll", query = "SELECT c FROM CursoEstudiante c")
    , @NamedQuery(name = "CursoEstudiante.findByIdEstudianteCurso", query = "SELECT c FROM CursoEstudiante c WHERE c.idEstudianteCurso = :idEstudianteCurso")
    , @NamedQuery(name = "CursoEstudiante.findByCurso", query = "SELECT ec FROM CursoEstudiante ec WHERE ec.idEstudianteFk.idCarreraFk.idDepartamentoFk.idDepartamento= :idDepto AND ec.idCursosFk.idCurso= :idCurso")
    , @NamedQuery(name = "CursoEstudiante.findByEstadoCursoEstudiante", query = "SELECT c FROM CursoEstudiante c WHERE c.estadoCursoEstudiante = :estadoCursoEstudiante")})
public class CursoEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudiante_curso", nullable = false)
    private Integer idEstudianteCurso;
    @Column(name = "estado_curso_estudiante")
    private Boolean estadoCursoEstudiante;
    @JoinColumn(name = "id_cursos_fk", referencedColumnName = "id_curso")
    @ManyToOne
    private Curso idCursosFk;
    @JoinColumn(name = "id_estudiante_fk", referencedColumnName = "id_estudiante")
    @ManyToOne
    private Estudiante idEstudianteFk;

    public CursoEstudiante() {
    }

    public CursoEstudiante(Integer idEstudianteCurso) {
        this.idEstudianteCurso = idEstudianteCurso;
    }

    public Integer getIdEstudianteCurso() {
        return idEstudianteCurso;
    }

    public void setIdEstudianteCurso(Integer idEstudianteCurso) {
        this.idEstudianteCurso = idEstudianteCurso;
    }

    public Boolean getEstadoCursoEstudiante() {
        return estadoCursoEstudiante;
    }

    public void setEstadoCursoEstudiante(Boolean estadoCursoEstudiante) {
        this.estadoCursoEstudiante = estadoCursoEstudiante;
    }

    public Curso getIdCursosFk() {
        return idCursosFk;
    }

    public void setIdCursosFk(Curso idCursosFk) {
        this.idCursosFk = idCursosFk;
    }

    public Estudiante getIdEstudianteFk() {
        return idEstudianteFk;
    }

    public void setIdEstudianteFk(Estudiante idEstudianteFk) {
        this.idEstudianteFk = idEstudianteFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudianteCurso != null ? idEstudianteCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoEstudiante)) {
            return false;
        }
        CursoEstudiante other = (CursoEstudiante) object;
        if ((this.idEstudianteCurso == null && other.idEstudianteCurso != null) || (this.idEstudianteCurso != null && !this.idEstudianteCurso.equals(other.idEstudianteCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "decanatoues.cursoues.entity.CursoEstudiante[ idEstudianteCurso=" + idEstudianteCurso + " ]";
    }

}
