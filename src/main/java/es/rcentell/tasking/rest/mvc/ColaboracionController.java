package es.rcentell.tasking.rest.mvc;

import es.rcentell.tasking.core.models.entities.Colaboracion;
import es.rcentell.tasking.core.services.ColaboracionService;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.*;
import es.rcentell.tasking.core.services.utils.ListaDistribucionList;
import es.rcentell.tasking.core.services.utils.RolList;
import es.rcentell.tasking.core.services.utils.SubtareaList;
import es.rcentell.tasking.core.services.utils.TareaList;
import es.rcentell.tasking.rest.exceptions.NotFoundException;
import es.rcentell.tasking.rest.resources.*;
import es.rcentell.tasking.rest.resources.impl.ColaboracionResourceImpl;
import es.rcentell.tasking.rest.resources.impl.ListaDistribucionListResourceImpl;
import es.rcentell.tasking.rest.resources.impl.SubtareaListResourceImpl;
import es.rcentell.tasking.rest.resources.impl.TareaListResourceImpl;
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
@RequestMapping("/rest/colaboraciones")
public class ColaboracionController {
    private ColaboracionService colaboracionService;

    @Autowired
    public ColaboracionController(ColaboracionService colaboracionService)
    {
        this.colaboracionService=colaboracionService;
    }


    @RequestMapping(value = "/test")
    public String test(){
        return "view";
    }

    @RequestMapping(value = "/{colaboracionId}",
            method = RequestMethod.GET)
    public ResponseEntity<ColaboracionResource> getColaboracion(@PathVariable Long colaboracionId){
        Colaboracion colaboracion = colaboracionService.findColaboracion(colaboracionId);
        if (colaboracion!=null)
        {
            ColaboracionResource res = new ColaboracionResourceImpl().toResource(colaboracion);
            return new ResponseEntity<ColaboracionResource>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<ColaboracionResource>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value="/{colaboracionId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<ColaboracionResource> deleteColaboracion(
            @PathVariable Long colaboracionId) {
        Colaboracion entry = colaboracionService.deleteColaboracion(colaboracionId);
        if(entry != null)
        {
            ColaboracionResource res = new ColaboracionResourceImpl().toResource(entry);
            return new ResponseEntity<ColaboracionResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ColaboracionResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{colaboracionId}",
            method = RequestMethod.PUT)
    public ResponseEntity<ColaboracionResource> updateColaboracion(
            @PathVariable Long colaboracionId, @RequestBody ColaboracionResource sentColaboracion) {
        Colaboracion updatedColaboracion = colaboracionService.updateColaboracion(colaboracionId, sentColaboracion.toColaboracion());
        if(updatedColaboracion != null)
        {
            ColaboracionResource res = new ColaboracionResourceImpl().toResource(updatedColaboracion);
            return new ResponseEntity<ColaboracionResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ColaboracionResource>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ColaboracionResource> createColaboracion(
            @RequestBody ColaboracionMapper colaboracionMapper) {
        Colaboracion createdColaboracion = null;
        try {
            createdColaboracion = colaboracionService.createColaboracion(colaboracionMapper.getProyecto(),
                    colaboracionMapper.getUsuario(), colaboracionMapper.getColaboracion());
            ColaboracionResource createdResource = new ColaboracionResourceImpl().toResource(createdColaboracion);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<ColaboracionResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (ProyectoNotFoundException e) {
            throw new NotFoundException(e);
        } catch (UsuarioNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @RequestMapping(value="/{colaboracionId}/listasDistribucion")
    public ResponseEntity<ListaDistribucionListResource> findAllListasDistribucions(
            @PathVariable Long colaboracionId)
    {
        try {
            ListaDistribucionList list = colaboracionService.findAllListasDistribucion(colaboracionId);
            ListaDistribucionListResource res = new ListaDistribucionListResourceImpl().toResource(list);
            return new ResponseEntity<ListaDistribucionListResource>(res, HttpStatus.OK);
        } catch(ListaDistribucionNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }

    @RequestMapping(value="/{colaboracionId}/tareas/asignadas")
    public ResponseEntity<TareaListResource> findAllTareasAsiganadas(
            @PathVariable Long colaboracionId)
    {
        try {
            TareaList list = colaboracionService.findAllTareasAsiganadas(colaboracionId);
            TareaListResource res = new TareaListResourceImpl().toResource(list);
            return new ResponseEntity<TareaListResource>(res, HttpStatus.OK);
        } catch(TareaNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
    @RequestMapping(value="/{colaboracionId}/tareas/creadas")
    public ResponseEntity<TareaListResource> findAllTareasCreadas(
            @PathVariable Long colaboracionId)
    {
        try {
            TareaList list = colaboracionService.findAllTareasCreadas(colaboracionId);
            TareaListResource res = new TareaListResourceImpl().toResource(list);
            return new ResponseEntity<TareaListResource>(res, HttpStatus.OK);
        } catch(TareaNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
    @RequestMapping(value="/{colaboracionId}/subtareas/asignadas")
    public ResponseEntity<SubtareaListResource> findAllSubtareasAsiganadas(
            @PathVariable Long colaboracionId)
    {
        try {
            SubtareaList list = colaboracionService.findAllSubtareasAsiganadas(colaboracionId);
            SubtareaListResource res = new SubtareaListResourceImpl().toResource(list);
            return new ResponseEntity<SubtareaListResource>(res, HttpStatus.OK);
        } catch(SubtareaNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
    @RequestMapping(value="/{colaboracionId}/subtareas/creadas")
    public ResponseEntity<SubtareaListResource> findAllSubtareasCreadas(
            @PathVariable Long colaboracionId)
    {
        try {
            SubtareaList list = colaboracionService.findAllSubtareasCreadas(colaboracionId);
            SubtareaListResource res = new SubtareaListResourceImpl().toResource(list);
            return new ResponseEntity<SubtareaListResource>(res, HttpStatus.OK);
        } catch(SubtareaNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
}
