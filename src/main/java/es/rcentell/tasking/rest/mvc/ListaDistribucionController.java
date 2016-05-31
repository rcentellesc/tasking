package es.rcentell.tasking.rest.mvc;

import es.rcentell.tasking.core.models.entities.Colaboracion;
import es.rcentell.tasking.core.models.entities.ListaDistribucion;
import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.core.services.ListaDistribucionService;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.*;
import es.rcentell.tasking.core.services.utils.ColaboracionList;
import es.rcentell.tasking.core.services.utils.SubtareaList;
import es.rcentell.tasking.core.services.utils.TareaList;
import es.rcentell.tasking.rest.exceptions.NotFoundException;
import es.rcentell.tasking.rest.resources.*;
import es.rcentell.tasking.rest.resources.impl.*;
import es.rcentell.tasking.rest.resources.mapper.ColaboracionMapper;
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
@RequestMapping("/rest/listasDistribucion")
public class ListaDistribucionController {
    private ListaDistribucionService listaDistribucionService;

    @Autowired
    public ListaDistribucionController(ListaDistribucionService listaDistribucionService)
    {
        this.listaDistribucionService=listaDistribucionService;
    }


    @RequestMapping(value = "/test")
    public String test(){
        return "view";
    }

    @RequestMapping(value = "/{listaDistribucionId}",
            method = RequestMethod.GET)
    public ResponseEntity<ListaDistribucionResource> getListaDistribucion(@PathVariable Long listaDistribucionId){
        ListaDistribucion listaDistribucion = listaDistribucionService.findListaDistribucion(listaDistribucionId);
        if (listaDistribucion!=null)
        {
            ListaDistribucionResource res = new ListaDistribucionResourceImpl().toResource(listaDistribucion);
            return new ResponseEntity<ListaDistribucionResource>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<ListaDistribucionResource>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value="/{listaDistribucionId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<ListaDistribucionResource> deleteListaDistribucion(
            @PathVariable Long listaDistribucionId) {
        ListaDistribucion listaDistribucion = listaDistribucionService.deleteListaDistribucion(listaDistribucionId);
        if(listaDistribucion != null)
        {
            ListaDistribucionResource res = new ListaDistribucionResourceImpl().toResource(listaDistribucion);
            return new ResponseEntity<ListaDistribucionResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ListaDistribucionResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{listaDistribucionId}",
            method = RequestMethod.PUT)
    public ResponseEntity<ListaDistribucionResource> updateListaDistribucion(
            @PathVariable Long listaDistribucionId, @RequestBody ListaDistribucionResource sentListaDistribucion) {
        ListaDistribucion updatedListaDistribucion = listaDistribucionService.updateListaDistribucion(listaDistribucionId, sentListaDistribucion.toListaDistribucion());
        if(updatedListaDistribucion != null)
        {
            ListaDistribucionResource res = new ListaDistribucionResourceImpl().toResource(updatedListaDistribucion);
            return new ResponseEntity<ListaDistribucionResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ListaDistribucionResource>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value="/{listaDistribucionId}/colaboraciones")
    public ResponseEntity<ColaboracionListResource> findAllColaboraciones(
            @PathVariable Long listaDistribucionId)
    {
        try {
            ColaboracionList list = listaDistribucionService.findAllColaboraciones(listaDistribucionId);
            ColaboracionListResource res = new ColaboracionListResourceImpl().toResource(list);
            return new ResponseEntity<ColaboracionListResource>(res, HttpStatus.OK);
        } catch(ColaboracionNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
    @RequestMapping(value="/{listaDistribucionId}/subtareas/asignadas")
    public ResponseEntity<SubtareaListResource> findAllSubTareasAsignadas(
            @PathVariable Long listaDistribucionId)
    {
        try {
            SubtareaList list = listaDistribucionService.findAllSubTareasAsignadas(listaDistribucionId);
            SubtareaListResource res = new SubtareaListResourceImpl().toResource(list);
            return new ResponseEntity<SubtareaListResource>(res, HttpStatus.OK);
        } catch(SubtareaNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }

    @RequestMapping(value="/{listaDistribucionId}/tareas/asignadas")
    public ResponseEntity<TareaListResource> findAllTareasAsignadas(
            @PathVariable Long listaDistribucionId)
    {
        try {
            TareaList list = listaDistribucionService.findAllTareasAsignadas(listaDistribucionId);
            TareaListResource res = new TareaListResourceImpl().toResource(list);
            return new ResponseEntity<TareaListResource>(res, HttpStatus.OK);
        } catch(TareaNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
}
