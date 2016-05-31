package es.rcentell.tasking.rest.mvc;

import es.rcentell.tasking.core.models.entities.ListaDistribucion;
import es.rcentell.tasking.core.models.entities.Proyecto;
import es.rcentell.tasking.core.models.entities.Rol;
import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.core.services.ProyectoService;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.ColaboracionNotFoundException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.ListaDistribucionNotFoundException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.ProyectoNotFoundException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.RolNotFoundException;
import es.rcentell.tasking.core.services.utils.*;
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
@RequestMapping("/rest/proyectos")
public class ProyectoController {
    private ProyectoService proyectoService;

    @Autowired
    public ProyectoController(ProyectoService proyectoService)
    {
        this.proyectoService=proyectoService;
    }


    @RequestMapping(value = "/test")
    public String test(){
        return "view";
    }

    @RequestMapping(value = "/{proyectoId}",
            method = RequestMethod.GET)
    public ResponseEntity<ProyectoResource> getProyecto(@PathVariable Long proyectoId){
        Proyecto proyecto = proyectoService.findProyecto(proyectoId);
        if (proyecto!=null)
        {
            ProyectoResource res = new ProyectoResourceImpl().toResource(proyecto);
            return new ResponseEntity<ProyectoResource>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<ProyectoResource>(HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ProyectoListResource> findAllProyectos()
    {
        ProyectoList ProyectoList = proyectoService.findAllProyectos();
        ProyectoListResource ProyectoListRes = new ProyectoListResourceImpl().toResource(ProyectoList);
        return new ResponseEntity<ProyectoListResource>(ProyectoListRes, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProyectoResource> createProyecto(@RequestBody ProyectoResource newProyecto)
    {
        Proyecto createdProyecto = null;
        try {
            createdProyecto = proyectoService.createProyecto(newProyecto.toProyecto());
            ProyectoResource createdResource = new ProyectoResourceImpl().toResource(createdProyecto);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<ProyectoResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (ProyectoNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @RequestMapping(value = "/{proyectoId}",method = RequestMethod.PUT)
    public ResponseEntity<ProyectoResource> updateProyecto(@PathVariable Long proyectoId,
                                                           @RequestBody ProyectoResource sentProyecto) {
        Proyecto updatedProyecto = proyectoService.updateProyecto(proyectoId, sentProyecto.toProyecto());
        if (updatedProyecto != null) {
            ProyectoResource res = new ProyectoResourceImpl().toResource(updatedProyecto);
            return new ResponseEntity<ProyectoResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ProyectoResource>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value="/{proyectoId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<ProyectoResource> deleteProyecto(
            @PathVariable Long proyectoId) {
        Proyecto proyecto = proyectoService.deleteProyecto(proyectoId);
        if(proyecto != null)
        {
            ProyectoResource res = new ProyectoResourceImpl().toResource(proyecto);
            return new ResponseEntity<ProyectoResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ProyectoResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{proyectoId}/tarea",
            method = RequestMethod.POST)
    public ResponseEntity<TareaResource> createTarea(
            @PathVariable Long proyectoId,
            @RequestBody TareaResource newTarea
    ) {
        Tarea createdTarea = null;
        try {
            createdTarea = proyectoService.createTarea(proyectoId, newTarea.toTarea());
            TareaResource createdResource = new TareaResourceImpl().toResource(createdTarea);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<TareaResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (ProyectoNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @RequestMapping(value="/{proyectoId}/tareas")
    public ResponseEntity<TareaListResource> findAllTareas(
            @PathVariable Long proyectoId)
    {
        try {
            TareaList list = proyectoService.findAllTareas(proyectoId);
            TareaListResource res = new TareaListResourceImpl().toResource(list);
            return new ResponseEntity<TareaListResource>(res, HttpStatus.OK);
        } catch(ProyectoNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
    @RequestMapping(value="/{proyectoId}/tareas/desasignadas")
    public ResponseEntity<TareaListResource> findAllTareasDesasignadas(
            @PathVariable Long proyectoId)
    {
        try {
            TareaList list = proyectoService.findAllTareasDesasignadas(proyectoId);
            TareaListResource res = new TareaListResourceImpl().toResource(list);
            return new ResponseEntity<TareaListResource>(res, HttpStatus.OK);
        } catch(ProyectoNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }

    @RequestMapping(value="/{proyectoId}/rol",
            method = RequestMethod.POST)
    public ResponseEntity<RolResource> createRol(
            @PathVariable Long proyectoId,
            @RequestBody RolResource newRol
    ) {
        Rol createdRol = null;
        try {
            createdRol = proyectoService.createRol(proyectoId, newRol.toRol());
            RolResource createdResource = new RolResourceImpl().toResource(createdRol);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<RolResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (ProyectoNotFoundException e) {
            throw new NotFoundException(e);
        }
    }
    @RequestMapping(value="/{proyectoId}/roles")
    public ResponseEntity<RolListResource> findAllRoles(
            @PathVariable Long proyectoId)
    {
        try {
            RolList list = proyectoService.findAllRoles(proyectoId);
            RolListResource res = new RolListResourceImpl().toResource(list);
            return new ResponseEntity<RolListResource>(res, HttpStatus.OK);
        } catch(RolNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
    @RequestMapping(value="/{proyectoId}/listaDistribucion",
            method = RequestMethod.POST)
    public ResponseEntity<ListaDistribucionResource> createListaDistribucion(
            @PathVariable Long proyectoId,
            @RequestBody ListaDistribucionResource newListaDistribucion
    ) {
        ListaDistribucion createdListaDistribucion = null;
        try {
            createdListaDistribucion = proyectoService.createListaDistribucion(proyectoId, newListaDistribucion.toListaDistribucion());
            ListaDistribucionResource createdResource = new ListaDistribucionResourceImpl().toResource(createdListaDistribucion);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<ListaDistribucionResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (ProyectoNotFoundException e) {
            throw new NotFoundException(e);
        }
    }
    @RequestMapping(value="/{proyectoId}/listasDistribucion")
    public ResponseEntity<ListaDistribucionListResource> findAllListasDistribucion(
            @PathVariable Long proyectoId)
    {
        try {
            ListaDistribucionList list = proyectoService.findAllListasDistribucion(proyectoId);
            ListaDistribucionListResource res = new ListaDistribucionListResourceImpl().toResource(list);
            return new ResponseEntity<ListaDistribucionListResource>(res, HttpStatus.OK);
        } catch(ListaDistribucionNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
    @RequestMapping(value="/{proyectoId}/colaboraciones")
    public ResponseEntity<ColaboracionListResource> findAllColaboraciones(
            @PathVariable Long proyectoId)
    {
        try {
            ColaboracionList list = proyectoService.findAllColaboraciones(proyectoId);
            ColaboracionListResource res = new ColaboracionListResourceImpl().toResource(list);
            return new ResponseEntity<ColaboracionListResource>(res, HttpStatus.OK);
        } catch(ColaboracionNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
}
