package es.rcentell.tasking.rest.mvc;

import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.models.entities.Subtarea;
import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.core.services.TareaService;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.TareaNotFoundException;
import es.rcentell.tasking.core.services.utils.ComentarioList;
import es.rcentell.tasking.core.services.utils.SubtareaList;
import es.rcentell.tasking.rest.exceptions.NotFoundException;
import es.rcentell.tasking.rest.resources.*;
import es.rcentell.tasking.rest.resources.impl.*;
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
@RequestMapping("/rest/tareas")
public class TareaController {
    private TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService)
    {
        this.tareaService=tareaService;
    }


    @RequestMapping(value = "/test")
    public String test(){
        return "view";
    }

    @RequestMapping(value = "/{tareaId}",
            method = RequestMethod.GET)
    public ResponseEntity<TareaResource> getTarea(@PathVariable Long tareaId){
        Tarea tarea = tareaService.findTarea(tareaId);
        if (tarea!=null)
        {
            TareaResource res = new TareaResourceImpl().toResource(tarea);
            return new ResponseEntity<TareaResource>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<TareaResource>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value="/{tareaId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<TareaResource> deleteTarea(
            @PathVariable Long tareaId) {
        Tarea entry = tareaService.deleteTarea(tareaId);
        if(entry != null)
        {
            TareaResource res = new TareaResourceImpl().toResource(entry);
            return new ResponseEntity<TareaResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<TareaResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{tareaId}",
            method = RequestMethod.PUT)
    public ResponseEntity<TareaResource> updateTarea(
            @PathVariable Long tareaId, @RequestBody TareaResource sentTarea) {
        Tarea updatedTarea = tareaService.updateTarea(tareaId, sentTarea.toTarea());
        if(updatedTarea != null)
        {
            TareaResource res = new TareaResourceImpl().toResource(updatedTarea);
            return new ResponseEntity<TareaResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<TareaResource>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value="/{tareaId}/comentarios")
    public ResponseEntity<ComentarioListResource> findAllComentarios(
            @PathVariable Long tareaId)
    {
        try {
            ComentarioList list = tareaService.findAllComentarios(tareaId);
            ComentarioListResource res = new ComentarioListResourceImpl().toResource(list);
            return new ResponseEntity<ComentarioListResource>(res, HttpStatus.OK);
        } catch(TareaNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
    @RequestMapping(value="/{tareaId}/subtareas")
    public ResponseEntity<SubtareaListResource> findAllSubtareas(
            @PathVariable Long tareaId)
    {
        try {
            SubtareaList list = tareaService.findAllSubtareas(tareaId);
            SubtareaListResource res = new SubtareaListResourceImpl().toResource(list);
            return new ResponseEntity<SubtareaListResource>(res, HttpStatus.OK);
        } catch(TareaNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
    @RequestMapping(value="/{tareaId}/comentario",
            method = RequestMethod.POST)
    public ResponseEntity<ComentarioResource> createComentario(
            @PathVariable Long tareaId,
            @RequestBody ComentarioResource newComentario
    ) {
        Comentario createdComentario = null;
        try {
            createdComentario = tareaService.createComentario(tareaId, newComentario.toComentario());
            ComentarioResource createdResource = new ComentarioResourceImpl().toResource(createdComentario);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<ComentarioResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (TareaNotFoundException e) {
            throw new NotFoundException(e);
        }
    }
    @RequestMapping(value="/{tareaId}/subtarea",
            method = RequestMethod.POST)
    public ResponseEntity<SubtareaResource> createSubtarea(
            @PathVariable Long tareaId,
            @RequestBody SubtareaResource newSubtarea
    ) {
        Subtarea createdSubtarea = null;
        try {
            createdSubtarea = tareaService.createSubtarea(tareaId, newSubtarea.toSubtarea());
            SubtareaResource createdResource = new SubtareaResourceImpl().toResource(createdSubtarea);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<SubtareaResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (TareaNotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
