package es.rcentell.tasking.rest.resources;

import es.rcentell.tasking.core.models.entities.Rol;
import es.rcentell.tasking.core.models.entities.Tarea;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class RolResource extends ResourceSupport {

    private String nombre;
    private String descripcion;
    private int indEdicion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIndEdicion() {
        return indEdicion;
    }

    public void setIndEdicion(int indEdicion) {
        this.indEdicion = indEdicion;
    }

    public Rol toRol() {
        Rol rol= new Rol();
        rol.setNombre(nombre);
        rol.setDescripcion(descripcion);
        rol.setIndEdicion(indEdicion);
        return rol;
    }
}
