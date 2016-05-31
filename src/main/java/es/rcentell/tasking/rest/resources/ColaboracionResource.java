package es.rcentell.tasking.rest.resources;

import es.rcentell.tasking.core.models.entities.Colaboracion;
import es.rcentell.tasking.core.models.entities.Rol;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.Set;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ColaboracionResource extends ResourceSupport {

    private Date fechaColaboracion;
    private Set<Rol>  roles;

    public Date getFechaColaboracion() {
        return fechaColaboracion;
    }

    public void setFechaColaboracion(Date fechaColaboracion) {
        this.fechaColaboracion = fechaColaboracion;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public Colaboracion toColaboracion() {
        Colaboracion colaboracion= new Colaboracion();
        colaboracion.setFechaColaboracion(fechaColaboracion);
        colaboracion.setRoles(roles);
        return colaboracion;
    }
}
