package es.rcentell.tasking.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ListaDistribucionListResource extends ResourceSupport {

    private List<ListaDistribucionResource> listasDistribucion;

    public List<ListaDistribucionResource> getListasDistribucion() {
        return listasDistribucion;
    }

    public void setListasDistribucion(List<ListaDistribucionResource> listasDistribucion) {
        this.listasDistribucion = listasDistribucion;
    }
}
