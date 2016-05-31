package es.rcentell.tasking.core.services.utils;

import es.rcentell.tasking.core.models.entities.Rol;
import es.rcentell.tasking.core.models.entities.Tarea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class RolList {
    private List<Rol> roles = new ArrayList<Rol>();
    private Long proyectoId;

    public RolList(Long proyectoId, List<Rol> roles) {
        this.proyectoId = proyectoId;
        this.roles = roles;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Long getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Long proyectoId) {
        this.proyectoId = proyectoId;
    }
}
