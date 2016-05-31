package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.services.utils.SubtareaList;
import es.rcentell.tasking.rest.mvc.SubtareaController;
import es.rcentell.tasking.rest.mvc.TareaController;
import es.rcentell.tasking.rest.resources.SubtareaListResource;
import es.rcentell.tasking.rest.resources.SubtareaResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class SubtareaListResourceImpl extends ResourceAssemblerSupport<SubtareaList, SubtareaListResource> {
    public SubtareaListResourceImpl() {
        super(SubtareaController.class, SubtareaListResource.class);
    }

    @Override
    public SubtareaListResource toResource(SubtareaList list) {
        List<SubtareaResource> resources = new SubtareaResourceImpl().toResources(list.getSubtareas());
        SubtareaListResource listResource = new SubtareaListResource();
        listResource.setSubtareas(resources);
        if(list.getTareaId()!=null)
        {
            listResource.add(linkTo(methodOn(TareaController.class).findAllSubtareas(list.getTareaId())).withSelfRel());
        }
        return listResource;
    }
}
