package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.core.services.utils.TareaList;
import es.rcentell.tasking.rest.mvc.ProyectoController;
import es.rcentell.tasking.rest.mvc.TareaController;
import es.rcentell.tasking.rest.resources.TareaListResource;
import es.rcentell.tasking.rest.resources.TareaResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class TareaListResourceImpl extends ResourceAssemblerSupport<TareaList, TareaListResource> {
    public TareaListResourceImpl() {
        super(TareaController.class, TareaListResource.class);
    }

    @Override
    public TareaListResource toResource(TareaList list) {
        List<TareaResource> resources = new TareaResourceImpl().toResources(list.getTareas());
        TareaListResource listResource = new TareaListResource();
        listResource.setTareas(resources);
        if(list.getProyectoId()!=null){
            listResource.add(linkTo(methodOn(ProyectoController.class).findAllTareas(list.getProyectoId())).withSelfRel());}
        return listResource;
    }
}
