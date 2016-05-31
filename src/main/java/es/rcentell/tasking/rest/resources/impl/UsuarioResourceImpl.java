package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.models.entities.Proyecto;
import es.rcentell.tasking.core.models.entities.Usuario;
import es.rcentell.tasking.rest.mvc.ProyectoController;
import es.rcentell.tasking.rest.mvc.UsuarioController;
import es.rcentell.tasking.rest.resources.ProyectoResource;
import es.rcentell.tasking.rest.resources.UsuarioResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class UsuarioResourceImpl extends ResourceAssemblerSupport<Usuario,UsuarioResource>{

    public UsuarioResourceImpl() {
        super(UsuarioController.class, UsuarioResource.class);
    }

    @Override
    public UsuarioResource toResource(Usuario usuario) {
        UsuarioResource res = new UsuarioResource();
        res.setNombre(usuario.getNombre());
        res.setLogin(usuario.getLogin());
        res.setPassword(usuario.getPassword());
        res.setEmail(usuario.getEmail());
        res.setFechaRegistro(usuario.getFechaRegistro());
        res.add(linkTo(UsuarioController.class).slash(usuario.getId()).withSelfRel());
        res.add(linkTo(UsuarioController.class).slash(usuario.getId()).slash("colaboraciones").withRel("colaboraciones"));
        res.add(linkTo(UsuarioController.class).slash(usuario.getId()).slash("proyectos").slash("creados").withRel("proyectosCreados"));
        return res;
    }
}
