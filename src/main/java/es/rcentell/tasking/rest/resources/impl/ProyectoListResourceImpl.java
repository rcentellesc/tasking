package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.models.entities.Proyecto;
import es.rcentell.tasking.core.services.utils.ProyectoList;
import es.rcentell.tasking.rest.mvc.ProyectoController;
import es.rcentell.tasking.rest.resources.ProyectoListResource;
import es.rcentell.tasking.rest.resources.ProyectoResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ProyectoListResourceImpl extends ResourceAssemblerSupport<ProyectoList,ProyectoListResource>{

    public ProyectoListResourceImpl() {
        super(ProyectoController.class, ProyectoListResource.class);
    }

    @Override
    public ProyectoListResource toResource(ProyectoList proyectoList) {

        ProyectoListResource res = new ProyectoListResource();
            res.setProyectos(new ProyectoResourceImpl().toResources(proyectoList.getProyectos()));
            return res;

    }
}
