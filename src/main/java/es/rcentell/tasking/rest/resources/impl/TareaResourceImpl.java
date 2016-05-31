package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.rest.mvc.ColaboracionController;
import es.rcentell.tasking.rest.mvc.ProyectoController;
import es.rcentell.tasking.rest.mvc.TareaController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import es.rcentell.tasking.rest.resources.TareaResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class TareaResourceImpl extends ResourceAssemblerSupport<Tarea,TareaResource>{

    public TareaResourceImpl() {
        super(TareaController.class, TareaResource.class);
    }

    @Override
    public TareaResource toResource(Tarea tarea) {
        TareaResource res = new TareaResource();
        res.setNombre(tarea.getNombre());
        res.setDescripcion(tarea.getDescripcion());
        res.setEstado(tarea.getEstado());
        res.setFechaActualizacion(tarea.getFechaActualizacion());
        res.setFechaCreacion(tarea.getFechaCreacion());
        res.setFechaLimite(tarea.getFechaLimite());
        res.setTipo(tarea.getTipo());
        res.add(linkTo(TareaController.class).slash(tarea.getId()).withSelfRel());
        res.add(linkTo(TareaController.class).slash(tarea.getId()).slash("comentarios").withRel("comentarios"));
        res.add(linkTo(TareaController.class).slash(tarea.getId()).slash("subtareas").withRel("subtareas"));
        if(tarea.getCreador() != null)
        {
            res.add((linkTo(ColaboracionController.class).slash(tarea.getCreador().getId()).withRel("creador")));
        }
        if(tarea.getAsignacion() != null)
        {
            res.add((linkTo(ColaboracionController.class).slash(tarea.getAsignacion().getId()).withRel("asignacion")));
        }
        if(tarea.getProyecto() != null)
        {
            res.add((linkTo(ProyectoController.class).slash(tarea.getProyecto().getId()).withRel("proyecto")));
        }
        return res;
    }
}
