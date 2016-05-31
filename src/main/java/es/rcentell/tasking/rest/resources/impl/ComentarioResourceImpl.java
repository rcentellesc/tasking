package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.models.entities.Colaboracion;
import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.rest.mvc.ColaboracionController;
import es.rcentell.tasking.rest.mvc.ComentarioController;
import es.rcentell.tasking.rest.mvc.SubtareaController;
import es.rcentell.tasking.rest.mvc.TareaController;
import es.rcentell.tasking.rest.resources.ComentarioResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ComentarioResourceImpl extends ResourceAssemblerSupport<Comentario,ComentarioResource>{

    public ComentarioResourceImpl() {
        super(ComentarioController.class, ComentarioResource.class);
    }

    @Override
    public ComentarioResource toResource(Comentario comentario) {
        ComentarioResource res = new ComentarioResource();
        res.setComentario(comentario.getComentario());
        res.setFechaCreacion(comentario.getFechaCreacion());
        res.add(linkTo(ComentarioController.class).slash(comentario.getId()).withSelfRel());
        if(comentario.getTarea() != null)
        {
            res.add((linkTo(TareaController.class).slash(comentario.getTarea().getId()).withRel("tarea")));
        }
        if(comentario.getCreador() != null)
        {
            res.add((linkTo(ColaboracionController.class).slash(comentario.getCreador().getId()).withRel("creador")));
        }
        if(comentario.getSubtarea()!=null)
        {
            res.add((linkTo(SubtareaController.class).slash(comentario.getSubtarea().getId()).withRel("subtarea")));
        }
        return res;
    }
}
