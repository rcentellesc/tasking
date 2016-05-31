package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.services.utils.ColaboracionList;
import es.rcentell.tasking.rest.mvc.ProyectoController;
import es.rcentell.tasking.rest.mvc.ColaboracionController;
import es.rcentell.tasking.rest.mvc.UsuarioController;
import es.rcentell.tasking.rest.resources.ColaboracionListResource;
import es.rcentell.tasking.rest.resources.ColaboracionResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ColaboracionListResourceImpl extends ResourceAssemblerSupport<ColaboracionList, ColaboracionListResource> {
    public ColaboracionListResourceImpl() {
        super(ColaboracionController.class, ColaboracionListResource.class);
    }

    @Override
    public ColaboracionListResource toResource(ColaboracionList list) {
        List<ColaboracionResource> resources = new ColaboracionResourceImpl().toResources(list.getColaboraciones());
        ColaboracionListResource listResource = new ColaboracionListResource();
        listResource.setColaboraciones(resources);
        if(list.getProyectoId()!=null)
            listResource.add(linkTo(methodOn(ProyectoController.class).findAllColaboraciones(list.getProyectoId())).withSelfRel());
        if(list.getUsuarioId()!=null)
            listResource.add(linkTo(methodOn(UsuarioController.class).findAllColaboraciones(list.getUsuarioId())).withSelfRel());
        return listResource;
    }
}
