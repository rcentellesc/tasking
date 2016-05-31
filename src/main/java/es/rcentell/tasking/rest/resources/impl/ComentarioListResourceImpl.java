package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.services.utils.ComentarioList;
import es.rcentell.tasking.rest.mvc.ComentarioController;
import es.rcentell.tasking.rest.mvc.SubtareaController;
import es.rcentell.tasking.rest.mvc.TareaController;
import es.rcentell.tasking.rest.resources.ComentarioListResource;
import es.rcentell.tasking.rest.resources.ComentarioResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ComentarioListResourceImpl extends ResourceAssemblerSupport<ComentarioList, ComentarioListResource> {
    public ComentarioListResourceImpl() {
        super(ComentarioController.class, ComentarioListResource.class);
    }

    @Override
    public ComentarioListResource toResource(ComentarioList list) {
        List<ComentarioResource> resources = new ComentarioResourceImpl().toResources(list.getComentarios());
        ComentarioListResource listResource = new ComentarioListResource();
        listResource.setComentarios(resources);
        if(list.getTareaId()!=null) {
            listResource.add(linkTo(methodOn(TareaController.class).findAllComentarios(list.getTareaId())).withSelfRel());
        }
        if(list.getSubtareaId()!=null) {
            listResource.add(linkTo(methodOn(SubtareaController.class).findAllComentarios(list.getSubtareaId())).withSelfRel());
        }
        return listResource;
    }
}
