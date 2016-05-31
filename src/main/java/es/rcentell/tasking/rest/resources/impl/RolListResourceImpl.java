package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.services.utils.RolList;
import es.rcentell.tasking.core.services.utils.TareaList;
import es.rcentell.tasking.rest.mvc.ProyectoController;
import es.rcentell.tasking.rest.mvc.RolController;
import es.rcentell.tasking.rest.mvc.TareaController;
import es.rcentell.tasking.rest.resources.RolListResource;
import es.rcentell.tasking.rest.resources.RolResource;
import es.rcentell.tasking.rest.resources.TareaListResource;
import es.rcentell.tasking.rest.resources.TareaResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class RolListResourceImpl extends ResourceAssemblerSupport<RolList, RolListResource> {
    public RolListResourceImpl() {
        super(RolController.class, RolListResource.class);
    }

    @Override
    public RolListResource toResource(RolList list) {
        List<RolResource> resources = new RolResourceImpl().toResources(list.getRoles());
        RolListResource listResource = new RolListResource();
        listResource.setRoles(resources);
        listResource.add(linkTo(methodOn(ProyectoController.class).findAllRoles(list.getProyectoId())).withSelfRel());
        return listResource;
    }
}
