package es.rcentell.tasking.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ProyectoListResource extends ResourceSupport {

    private List<ProyectoResource> proyectos = new ArrayList<ProyectoResource>();

    public List<ProyectoResource> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<ProyectoResource> proyectos) {
        this.proyectos = proyectos;
    }
}
