package es.rcentell.tasking.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ComentarioListResource extends ResourceSupport {

    private List<ComentarioResource> comentarios;

    public List<ComentarioResource> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioResource> comentarios) {
        this.comentarios = comentarios;
    }
}
