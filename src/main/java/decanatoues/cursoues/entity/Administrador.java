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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gochez
 */
@Entity
@Table(name = "administrador", catalog = "cursos", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.idAdministrador = :idAdministrador")
    , @NamedQuery(name = "Administrador.findByNombreAdministrador", query = "SELECT a FROM Administrador a WHERE a.nombreAdministrador = :nombreAdministrador")
    , @NamedQuery(name = "Administrador.findByApellidoAdministrador", query = "SELECT a FROM Administrador a WHERE a.apellidoAdministrador = :apellidoAdministrador")
    , @NamedQuery(name = "Administrador.findByNombreUsuario", query = "SELECT a FROM Administrador a WHERE a.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Administrador.findByContrasenia", query = "SELECT a FROM Administrador a WHERE a.contrasenia = :contrasenia")
    , @NamedQuery(name = "Administrador.findByCorreoAdmin", query = "SELECT a FROM Administrador a WHERE a.correoAdmin = :correoAdmin")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_administrador", nullable = false)
    private Integer idAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "nombre_administrador", nullable = false, length = 75)
    private String nombreAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "apellido_administrador", nullable = false, length = 75)
    private String apellidoAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_usuario", nullable = false, length = 25)
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "contrasenia", nullable = false, length = 64)
    private String contrasenia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo_admin", nullable = false, length = 100)
    private String correoAdmin;

    public Administrador() {
    }

    public Administrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Administrador(Integer idAdministrador, String nombreAdministrador, String apellidoAdministrador, String nombreUsuario, String contrasenia, String correoAdmin) {
        this.idAdministrador = idAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.apellidoAdministrador = apellidoAdministrador;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correoAdmin = correoAdmin;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getApellidoAdministrador() {
        return apellidoAdministrador;
    }

    public void setApellidoAdministrador(String apellidoAdministrador) {
        this.apellidoAdministrador = apellidoAdministrador;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreoAdmin() {
        return correoAdmin;
    }

    public void setCorreoAdmin(String correoAdmin) {
        this.correoAdmin = correoAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministrador != null ? idAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idAdministrador == null && other.idAdministrador != null) || (this.idAdministrador != null && !this.idAdministrador.equals(other.idAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "decanatoues.cursoues.entity.Administrador[ idAdministrador=" + idAdministrador + " ]";
    }
    
}
