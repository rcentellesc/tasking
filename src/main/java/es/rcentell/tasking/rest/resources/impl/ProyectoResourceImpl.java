package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.models.entities.Proyecto;
import es.rcentell.tasking.rest.mvc.ColaboracionController;
import es.rcentell.tasking.rest.mvc.ListaDistribucionController;
import es.rcentell.tasking.rest.mvc.ProyectoController;
import es.rcentell.tasking.rest.resources.ProyectoResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ProyectoResourceImpl extends ResourceAssemblerSupport<Proyecto,ProyectoResource>{

    public ProyectoResourceImpl() {
        super(ProyectoController.class, ProyectoResource.class);
    }

    @Override
    public ProyectoResource toResource(Proyecto proyecto) {
        ProyectoResource res = new ProyectoResource();
        res.setNombre(proyecto.getNombre());
        res.setCodigo(proyecto.getCodigo());
        res.setDescripcion(proyecto.getDescripcion());
        res.add(linkTo(ProyectoController.class).slash(proyecto.getId()).withSelfRel());
        res.add(linkTo(ProyectoController.class).slash(proyecto.getId()).slash("listasDistribucions").withRel("listasDistribucion"));
        res.add(linkTo(ProyectoController.class).slash(proyecto.getId()).slash("tareas").withRel("tareas"));
        res.add(linkTo(ProyectoController.class).slash(proyecto.getId()).slash("tareas").slash("desasignadas").withRel("tareasDesasignadas"));
        res.add(linkTo(ProyectoController.class).slash(proyecto.getId()).slash("colaboraciones").withRel("colaboraciones"));
        if(proyecto.getCreador() != null)
        {
            res.add((linkTo(ColaboracionController.class).slash(proyecto.getCreador().getId()).withRel("creador")));
        }
        return res;
    }
}
