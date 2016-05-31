package es.rcentell.tasking.rest.mvc;

import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.core.services.ComentarioService;
import es.rcentell.tasking.core.services.TareaService;
import es.rcentell.tasking.rest.resources.ComentarioResource;
import es.rcentell.tasking.rest.resources.TareaResource;
import es.rcentell.tasking.rest.resources.impl.ComentarioResourceImpl;
import es.rcentell.tasking.rest.resources.impl.TareaResourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Controller
@RequestMapping("/rest/comentarios")
public class ComentarioController {
    private ComentarioService comentarioService;

    @Autowired
    public ComentarioController(ComentarioService comentarioService)
    {
        this.comentarioService=comentarioService;
    }


    @RequestMapping(value = "/test")
    public String test(){
        return "view";
    }

    @RequestMapping(value = "/{comentarioId}",
            method = RequestMethod.GET)
    public ResponseEntity<ComentarioResource> getComentario(@PathVariable Long comentarioId){
        Comentario comentario = comentarioService.findComentario(comentarioId);
        if (comentario!=null)
        {
            ComentarioResource res = new ComentarioResourceImpl().toResource(comentario);
            return new ResponseEntity<ComentarioResource>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<ComentarioResource>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value="/{comentarioId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<ComentarioResource> deleteComentario(
            @PathVariable Long comentarioId) {
        Comentario comentario = comentarioService.deleteComentario(comentarioId);
        if(comentario != null)
        {
            ComentarioResource res = new ComentarioResourceImpl().toResource(comentario);
            return new ResponseEntity<ComentarioResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ComentarioResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{comentarioId}",
            method = RequestMethod.PUT)
    public ResponseEntity<ComentarioResource> updateComentario(
            @PathVariable Long comentarioId, @RequestBody ComentarioResource sentComentario) {
        Comentario updatedComentario = comentarioService.updateComentario(comentarioId, sentComentario.toComentario());
        if(updatedComentario != null)
        {
            ComentarioResource res = new ComentarioResourceImpl().toResource(updatedComentario);
            return new ResponseEntity<ComentarioResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ComentarioResource>(HttpStatus.NOT_FOUND);
        }
    }
}
