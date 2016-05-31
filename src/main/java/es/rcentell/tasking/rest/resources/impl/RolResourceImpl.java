package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.models.entities.Rol;
import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.rest.mvc.ProyectoController;
import es.rcentell.tasking.rest.mvc.RolController;
import es.rcentell.tasking.rest.mvc.TareaController;
import es.rcentell.tasking.rest.resources.RolResource;
import es.rcentell.tasking.rest.resources.TareaResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class RolResourceImpl extends ResourceAssemblerSupport<Rol,RolResource>{

    public RolResourceImpl() {
        super(RolController.class, RolResource.class);
    }

    @Override
    public RolResource toResource(Rol rol) {
        RolResource res = new RolResource();
        res.setNombre(rol.getNombre());
        res.setDescripcion(rol.getDescripcion());
        res.setIndEdicion(rol.getIndEdicion());
        res.add(linkTo(RolController.class).slash(rol.getId()).withSelfRel());
        if(rol.getProyecto() != null)
        {
            res.add((linkTo(ProyectoController.class).slash(rol.getProyecto().getId()).withRel("proyecto")));
        }
        return res;
    }
}
