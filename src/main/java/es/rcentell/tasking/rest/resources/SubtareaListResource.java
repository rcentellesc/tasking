package es.rcentell.tasking.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class SubtareaListResource extends ResourceSupport {

    private List<SubtareaResource> subtareas;

    public List<SubtareaResource> getSubtareas() {
        return subtareas;
    }

    public void setSubtareas(List<SubtareaResource> subtareas) {
        this.subtareas = subtareas;
    }
}
