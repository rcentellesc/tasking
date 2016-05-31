package es.rcentell.tasking.rest.resources;

import es.rcentell.tasking.core.models.entities.Colaboracion;
import es.rcentell.tasking.core.models.entities.ListaDistribucion;
import org.springframework.hateoas.ResourceSupport;

import java.util.Set;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ListaDistribucionResource extends ResourceSupport {

    private String nombre;
    private String descripcion;
    private Set<Colaboracion> colaboraciones;

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

    public Set<Colaboracion> getColaboraciones() {
        return colaboraciones;
    }

    public void setColaboraciones(Set<Colaboracion> colaboraciones) {
        this.colaboraciones = colaboraciones;
    }

    public ListaDistribucion toListaDistribucion() {
        ListaDistribucion listaDistribucion= new ListaDistribucion();
        listaDistribucion.setNombre(nombre);
        listaDistribucion.setDescripcion(descripcion);
        listaDistribucion.setColaboraciones(colaboraciones);
        return listaDistribucion;
    }
}
