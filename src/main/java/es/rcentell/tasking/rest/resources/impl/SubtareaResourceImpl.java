package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.models.entities.Subtarea;
import es.rcentell.tasking.rest.mvc.ColaboracionController;
import es.rcentell.tasking.rest.mvc.SubtareaController;
import es.rcentell.tasking.rest.mvc.TareaController;
import es.rcentell.tasking.rest.resources.SubtareaResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class SubtareaResourceImpl extends ResourceAssemblerSupport<Subtarea,SubtareaResource>{

    public SubtareaResourceImpl() {
        super(SubtareaController.class, SubtareaResource.class);
    }

    @Override
    public SubtareaResource toResource(Subtarea subtarea) {
        SubtareaResource res = new SubtareaResource();
        res.setNombre(subtarea.getNombre());
        res.setDescripcion(subtarea.getDescripcion());
        res.setEstado(subtarea.getEstado());
        res.setFechaActualizacion(subtarea.getFechaActualizacion());
        res.setFechaCreacion(subtarea.getFechaCreacion());
        res.setFechaLimite(subtarea.getFechaLimite());
        res.setTipo(subtarea.getTipo());
        res.add(linkTo(SubtareaController.class).slash(subtarea.getId()).withSelfRel());
        res.add(linkTo(SubtareaController.class).slash(subtarea.getId()).slash("comentarios").withRel("comentarios"));
        if(subtarea.getCreador() != null)
        {
            res.add((linkTo(ColaboracionController.class).slash(subtarea.getCreador().getId()).withRel("creador")));
        }
        if(subtarea.getAsignacion() != null)
        {
            res.add((linkTo(ColaboracionController.class).slash(subtarea.getAsignacion().getId()).withRel("asignacion")));
        }
        if(subtarea.getTarea() != null)
        {
            res.add((linkTo(TareaController.class).slash(subtarea.getTarea().getId()).withRel("tarea")));
        }
        return res;
    }
}
