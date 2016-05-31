package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.services.utils.ListaDistribucionList;
import es.rcentell.tasking.rest.mvc.ProyectoController;
import es.rcentell.tasking.rest.mvc.ListaDistribucionController;
import es.rcentell.tasking.rest.resources.ListaDistribucionListResource;
import es.rcentell.tasking.rest.resources.ListaDistribucionResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ListaDistribucionListResourceImpl extends ResourceAssemblerSupport<ListaDistribucionList, ListaDistribucionListResource> {
    public ListaDistribucionListResourceImpl() {
        super(ListaDistribucionController.class, ListaDistribucionListResource.class);
    }

    @Override
    public ListaDistribucionListResource toResource(ListaDistribucionList list) {
        List<ListaDistribucionResource> resources = new ListaDistribucionResourceImpl().toResources(list.getListasDistribucion());
        ListaDistribucionListResource listResource = new ListaDistribucionListResource();
        listResource.setListasDistribucion(resources);
        listResource.add(linkTo(methodOn(ProyectoController.class).findAllListasDistribucion(list.getProyectoId())).withSelfRel());
        return listResource;
    }
}
