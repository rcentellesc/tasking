package es.rcentell.tasking.rest.resources;

import es.rcentell.tasking.core.models.entities.Usuario;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class UsuarioResource extends ResourceSupport {

    private String login;
    private String password;
    private String nombre;
    private String email;
    private Date fechaRegistro;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario toUsuario() {
        Usuario usuario= new Usuario();
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setLogin(login);
        usuario.setNombre(nombre);
        usuario.setFechaRegistro(fechaRegistro);
        return usuario;
    }
}
