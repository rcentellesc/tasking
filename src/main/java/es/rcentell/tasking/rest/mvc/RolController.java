package es.rcentell.tasking.rest.mvc;

import es.rcentell.tasking.core.models.entities.Rol;
import es.rcentell.tasking.core.services.RolService;
import es.rcentell.tasking.rest.resources.*;
import es.rcentell.tasking.rest.resources.impl.*;
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
@RequestMapping("/rest/roles")
public class RolController {
    private RolService rolService;

    @Autowired
    public RolController(RolService rolService)
    {
        this.rolService=rolService;
    }


    @RequestMapping(value = "/test")
    public String test(){
        return "view";
    }

    @RequestMapping(value = "/{rolId}",
            method = RequestMethod.GET)
    public ResponseEntity<RolResource> getRol(@PathVariable Long rolId){
        Rol rol = rolService.findRol(rolId);
        if (rol!=null)
        {
            RolResource res = new RolResourceImpl().toResource(rol);
            return new ResponseEntity<RolResource>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<RolResource>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value="/{rolId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<RolResource> deleteRol(
            @PathVariable Long rolId) {
        Rol rol = rolService.deleteRol(rolId);
        if(rol != null)
        {
            RolResource res = new RolResourceImpl().toResource(rol);
            return new ResponseEntity<RolResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<RolResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{rolId}",
            method = RequestMethod.PUT)
    public ResponseEntity<RolResource> updateRol(
            @PathVariable Long rolId, @RequestBody RolResource sentRol) {
        Rol updatedRol = rolService.updateRol(rolId, sentRol.toRol());
        if(updatedRol != null)
        {
            RolResource res = new RolResourceImpl().toResource(updatedRol);
            return new ResponseEntity<RolResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<RolResource>(HttpStatus.NOT_FOUND);
        }
    }
}
