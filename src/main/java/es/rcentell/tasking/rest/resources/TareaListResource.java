package es.rcentell.tasking.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class TareaListResource extends ResourceSupport {

    private List<TareaResource> tareas;

    public List<TareaResource> getTareas() {
        return tareas;
    }

    public void setTareas(List<TareaResource> tareas) {
        this.tareas = tareas;
    }
}
