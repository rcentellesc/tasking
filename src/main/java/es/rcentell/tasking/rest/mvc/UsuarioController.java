package es.rcentell.tasking.rest.mvc;


import es.rcentell.tasking.core.models.entities.Usuario;
import es.rcentell.tasking.core.services.UsuarioService;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.ColaboracionNotFoundException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.ProyectoNotFoundException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.UsuarioNotFoundException;
import es.rcentell.tasking.core.services.utils.ColaboracionList;
import es.rcentell.tasking.core.services.utils.ProyectoList;
import es.rcentell.tasking.rest.exceptions.NotFoundException;
import es.rcentell.tasking.rest.resources.ColaboracionListResource;
import es.rcentell.tasking.rest.resources.ProyectoListResource;
import es.rcentell.tasking.rest.resources.UsuarioResource;
import es.rcentell.tasking.rest.resources.impl.ColaboracionListResourceImpl;
import es.rcentell.tasking.rest.resources.impl.ProyectoListResourceImpl;
import es.rcentell.tasking.rest.resources.impl.UsuarioResourceImpl;
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
@RequestMapping("/rest/usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService)
    {
        this.usuarioService=usuarioService;
    }


    @RequestMapping(value = "/test")
    public String test(){
        return "view";
    }

    @RequestMapping(value = "/{usuarioId}",
            method = RequestMethod.GET)
    public ResponseEntity<UsuarioResource> getProyecto(@PathVariable Long usuarioId){
        Usuario usuario = usuarioService.findUsuario(usuarioId);
        if (usuario!=null)
        {
            UsuarioResource res = new UsuarioResourceImpl().toResource(usuario);
            return new ResponseEntity<UsuarioResource>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<UsuarioResource>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UsuarioResource> createUsuario(@RequestBody UsuarioResource newUsuario)
    {
        Usuario createdUsuario = null;
        try {
            createdUsuario = usuarioService.createUsuario(newUsuario.toUsuario());
            UsuarioResource createdResource = new UsuarioResourceImpl().toResource(createdUsuario);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<UsuarioResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (UsuarioNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @RequestMapping(value = "/{usuarioId}",method = RequestMethod.PUT)
    public ResponseEntity<UsuarioResource> updateUsuario(@PathVariable Long usuarioId,
                                                           @RequestBody UsuarioResource sentUsuario) {
        Usuario updatedUsuario = usuarioService.updateUsuario(usuarioId, sentUsuario.toUsuario());
        if (updatedUsuario != null) {
            UsuarioResource res = new UsuarioResourceImpl().toResource(updatedUsuario);
            return new ResponseEntity<UsuarioResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<UsuarioResource>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value="/{usuarioId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<UsuarioResource> deleteUsuario(
            @PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.deleteUsuario(usuarioId);
        if(usuario != null)
        {
            UsuarioResource res = new UsuarioResourceImpl().toResource(usuario);
            return new ResponseEntity<UsuarioResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<UsuarioResource>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value="/{usuarioId}/colaboraciones")
    public ResponseEntity<ColaboracionListResource> findAllColaboraciones(
            @PathVariable Long usuarioId)
    {
        try {
            ColaboracionList list = usuarioService.findAllColaboraciones(usuarioId);
            ColaboracionListResource res = new ColaboracionListResourceImpl().toResource(list);
            return new ResponseEntity<ColaboracionListResource>(res, HttpStatus.OK);
        } catch(ColaboracionNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
    @RequestMapping(value="/{usuarioId}/proyectos/creados")
    public ResponseEntity<ProyectoListResource> findAllProyectosCreados(
            @PathVariable Long usuarioId)
    {
        try {
            ProyectoList list = usuarioService.findAllProyectosByCreador(usuarioId);
            ProyectoListResource res = new ProyectoListResourceImpl().toResource(list);
            return new ResponseEntity<ProyectoListResource>(res, HttpStatus.OK);
        } catch(ProyectoNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
}
