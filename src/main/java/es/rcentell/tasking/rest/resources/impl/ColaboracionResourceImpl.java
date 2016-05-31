package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.models.entities.Colaboracion;
import es.rcentell.tasking.rest.mvc.ListaDistribucionController;
import es.rcentell.tasking.rest.mvc.ProyectoController;
import es.rcentell.tasking.rest.mvc.ColaboracionController;
import es.rcentell.tasking.rest.mvc.UsuarioController;
import es.rcentell.tasking.rest.resources.ColaboracionResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ColaboracionResourceImpl extends ResourceAssemblerSupport<Colaboracion,ColaboracionResource>{

    public ColaboracionResourceImpl() {
        super(ColaboracionController.class, ColaboracionResource.class);
    }

    @Override
    public ColaboracionResource toResource(Colaboracion colaboracion) {
        ColaboracionResource res = new ColaboracionResource();
        res.setFechaColaboracion(colaboracion.getFechaColaboracion());
        res.setRoles(colaboracion.getRoles());
        res.add(linkTo(ColaboracionController.class).slash(colaboracion.getId()).withSelfRel());
        res.add(linkTo(ColaboracionController.class).slash(colaboracion.getId()).slash("listasDistribucion").withRel("listasDistribucion"));
        res.add(linkTo(ColaboracionController.class).slash(colaboracion.getId()).slash("subtareas").slash("asignadas").withRel("subtareasAsignadas"));
        res.add(linkTo(ColaboracionController.class).slash(colaboracion.getId()).slash("tareas").slash("asignadas").withRel("tareasAsignadas"));
        res.add(linkTo(ColaboracionController.class).slash(colaboracion.getId()).slash("subtareas").slash("creadas").withRel("subtareasCreadas"));
        res.add(linkTo(ColaboracionController.class).slash(colaboracion.getId()).slash("tareas").slash("creadas").withRel("tareasCreadas"));
        if(colaboracion.getProyecto() != null)
        {
            res.add((linkTo(ProyectoController.class).slash(colaboracion.getProyecto().getId()).withRel("proyecto")));
        }
        if(colaboracion.getUsuario() != null)
        {
            res.add((linkTo(UsuarioController.class).slash(colaboracion.getUsuario().getId()).withRel("usuario")));
        }
        return res;
    }
}
