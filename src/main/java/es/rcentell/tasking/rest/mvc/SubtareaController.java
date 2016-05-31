package es.rcentell.tasking.rest.mvc;

import es.rcentell.tasking.core.models.entities.Colaboracion;
import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.models.entities.Subtarea;
import es.rcentell.tasking.core.services.ColaboracionService;
import es.rcentell.tasking.core.services.SubtareaService;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.SubtareaNotFoundException;
import es.rcentell.tasking.core.services.utils.ComentarioList;
import es.rcentell.tasking.rest.exceptions.NotFoundException;
import es.rcentell.tasking.rest.resources.ColaboracionResource;
import es.rcentell.tasking.rest.resources.ComentarioListResource;
import es.rcentell.tasking.rest.resources.ComentarioResource;
import es.rcentell.tasking.rest.resources.SubtareaResource;
import es.rcentell.tasking.rest.resources.impl.ComentarioListResourceImpl;
import es.rcentell.tasking.rest.resources.impl.ComentarioResourceImpl;
import es.rcentell.tasking.rest.resources.impl.SubtareaResourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Controller
@RequestMapping("/rest/subtareas")
public class SubtareaController {
    private SubtareaService subtareaService;

    @Autowired
    public SubtareaController(SubtareaService subtareaService){this.subtareaService=subtareaService;}


    @RequestMapping(value = "/test")
    public String test(){
        return "view";
    }

    @RequestMapping(value = "/{subtareaId}",
            method = RequestMethod.GET)
    public ResponseEntity<SubtareaResource> getSubtarea(@PathVariable Long subtareaId){
        Subtarea subtarea= subtareaService.findSubtarea(subtareaId);
        if (subtarea!=null)
        {
            SubtareaResource res = new SubtareaResourceImpl().toResource(subtarea);
            return new ResponseEntity<SubtareaResource>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<SubtareaResource>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value="/{subtareaId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<SubtareaResource> deleteSubtarea(
            @PathVariable Long subtareaId) {
        Subtarea subtarea = subtareaService.deleteSubtarea(subtareaId);
        if(subtarea != null)
        {
            SubtareaResource res = new SubtareaResourceImpl().toResource(subtarea);
            return new ResponseEntity<SubtareaResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<SubtareaResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{subtareaId}",
            method = RequestMethod.PUT)
    public ResponseEntity<SubtareaResource> updateSubtarea(
            @PathVariable Long subtareaId, @RequestBody SubtareaResource sentSubtarea) {
        Subtarea updatedSubtarea = subtareaService.updateSubtarea(subtareaId, sentSubtarea.toSubtarea());
        if(updatedSubtarea != null)
        {
            SubtareaResource res = new SubtareaResourceImpl().toResource(updatedSubtarea);
            return new ResponseEntity<SubtareaResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<SubtareaResource>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value="/{subtareaId}/comentarios")
    public ResponseEntity<ComentarioListResource> findAllComentarios(
            @PathVariable Long subtareaId)
    {
        try {
            ComentarioList list = subtareaService.findAllComentarios(subtareaId);
            ComentarioListResource res = new ComentarioListResourceImpl().toResource(list);
            return new ResponseEntity<ComentarioListResource>(res, HttpStatus.OK);
        } catch(SubtareaNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
    @RequestMapping(value="/{subtareaId}/comentario",
            method = RequestMethod.POST)
    public ResponseEntity<ComentarioResource> createComentario(
            @PathVariable Long subtareaId,
            @RequestBody ComentarioResource newComentario
    ) {
        Comentario createdComentario = null;
        try {
            createdComentario = subtareaService.createComentario(subtareaId, newComentario.toComentario());
            ComentarioResource createdResource = new ComentarioResourceImpl().toResource(createdComentario);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<ComentarioResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (SubtareaNotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
