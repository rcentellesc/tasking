package es.rcentell.tasking.rest.resources;

import es.rcentell.tasking.core.models.entities.Proyecto;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ProyectoResource extends ResourceSupport {

    private String nombre;
    private String codigo;
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proyecto toProyecto() {
        Proyecto proyecto= new Proyecto();
        proyecto.setCodigo(codigo);
        proyecto.setDescripcion(descripcion);
        proyecto.setNombre(nombre);
        return proyecto;
    }
}
