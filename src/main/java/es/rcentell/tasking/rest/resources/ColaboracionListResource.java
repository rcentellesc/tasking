package es.rcentell.tasking.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ColaboracionListResource extends ResourceSupport {

    private List<ColaboracionResource> colaboraciones;

    public List<ColaboracionResource> getColaboraciones() {
        return colaboraciones;
    }

    public void setColaboraciones(List<ColaboracionResource> colaboraciones) {
        this.colaboraciones = colaboraciones;
    }
}
