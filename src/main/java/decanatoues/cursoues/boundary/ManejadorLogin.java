package decanatoues.cursoues.boundary;

import decanatoues.cursoues.controller.AdministradorFacade;
import decanatoues.cursoues.cookie.CookieInstance;
import decanatoues.cursoues.entity.Administrador;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named
@ViewScoped
public class ManejadorLogin implements Serializable {

    @Inject
    private AdministradorFacade adf;

    private Administrador admin, Usuario, direc;
    private String redireccionar = null, nombreUsuario;
    private CookieInstance oreo;
    private int id, id2, idg;

    @PostConstruct
    public void init() {

        admin = new Administrador();
        oreo = new CookieInstance();
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public String autenticacion() {
        Administrador usuario;
        try {
            usuario = adf.autenticar(admin);
            //System.out.println(usuario.getContrasenia()+usuario.getNombreUsuario());
            if (usuario != null) {
                oreo.CrearCookie(usuario);
                redireccionar = "principal.jsf?faces-redirect=true";
                System.out.println(admin.getContrasenia()+admin.getNombreUsuario());
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "aviso:", "usuario o contraseña incorrectos"));
            }

        } catch (Exception ex) {
            throw ex;
        }
        return redireccionar;
    }

    public void login() {
        oreo.ComprobarLogin();
    }

    public void loginPrincipal() {
        oreo.ComprobarLoginPricipal();
    }
    
//    public boolean isadmin(){
//    id= oreo.UsuarioId();
//  //  Usuario= adf.find(id);
//        if (id==1) {
//            return true;
//        }else{
//        return false;
//        }
//    }

    public Administrador getUsuario() {
        return Usuario;
    }

    public void setUsuario(Administrador Usuario) {
        this.Usuario = Usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    



}
