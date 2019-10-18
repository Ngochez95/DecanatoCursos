/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanatoues.cursoues.cookie;

import decanatoues.cursoues.entity.Administrador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author katiro
 */
public class CookieInstance {

    private Cookie galleta;
    private Administrador directorio = new Administrador();
    private boolean control = false;
    private final String user = "usuario";
    private Cookie[] galletas;

    public CookieInstance() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        galletas = request.getCookies();
        if (galletas != null && galletas.length > 0) {
            for (Cookie cookie : galletas) {
                if (cookie.getName().equals(user)) {
                    galleta = cookie;
                    control = true;
                    break;
                }
            }
        }

    }

    public void CrearCookie(Administrador directory) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        galletas = request.getCookies();
        if (galletas != null && galletas.length > 0) {
            for (Cookie cookie : galletas) {
                if (cookie.getName().equals(user)) {
                    galleta = cookie;
                    control = true;
                    break;
                }
            }
        }
        if (control == true) {
            galleta.setValue(directory.getIdAdministrador().toString());
        } else {
            galleta = new Cookie(user, directory.getIdAdministrador().toString());
            galleta.setPath(request.getContextPath());
        }
        response.addCookie(galleta);
    }

    public int UsuarioId() {
        int id;
        if (control == true) {
            id = Integer.parseInt(galleta.getValue());
            return id;
        } else {
            return 0;
        }

    }

    public void cerrarSesion() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        try {
            galletas = request.getCookies();
            if (galleta != null && galletas.length > 0) {
                for (Cookie cookies : galletas) {
                    if (cookies.getName().equals(user)) {
                        cookies.setValue("");
                        cookies.setPath("/CursoUes-1.0-SNAPSHOT");
                        cookies.setMaxAge(0);
                        response.addCookie(cookies);
                        control = true;
                        break;
                    }
                }
                FacesContext.getCurrentInstance().getExternalContext().redirect("/index.jsf");
            }
        } catch (IOException ex) {
            Logger.getLogger(CookieInstance.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ComprobarLogin() {
        if (control == true) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("principal.jsf");
            } catch (IOException ex) {
                Logger.getLogger(CookieInstance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ComprobarLoginPricipal() {
        if (control == false) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
            } catch (IOException ex) {
                Logger.getLogger(CookieInstance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Administrador getDirectorio() {
        return directorio;
    }

    public void setDirectorio(Administrador directorio) {
        this.directorio = directorio;
    }


    

  

}
