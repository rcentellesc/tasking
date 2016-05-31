package es.rcentell.tasking.rest.resources.impl;

import es.rcentell.tasking.core.models.entities.ListaDistribucion;
import es.rcentell.tasking.rest.mvc.ProyectoController;
import es.rcentell.tasking.rest.mvc.ListaDistribucionController;
import es.rcentell.tasking.rest.resources.ListaDistribucionResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ListaDistribucionResourceImpl extends ResourceAssemblerSupport<ListaDistribucion,ListaDistribucionResource>{

    public ListaDistribucionResourceImpl() {
        super(ListaDistribucionController.class, ListaDistribucionResource.class);
    }

    @Override
    public ListaDistribucionResource toResource(ListaDistribucion listaDistribucion) {
        ListaDistribucionResource res = new ListaDistribucionResource();
        res.setNombre(listaDistribucion.getNombre());
        res.setDescripcion(listaDistribucion.getDescripcion());
        res.setColaboraciones(listaDistribucion.getColaboraciones());
        res.add(linkTo(ListaDistribucionController.class).slash(listaDistribucion.getId()).withSelfRel());
        res.add(linkTo(ListaDistribucionController.class).slash(listaDistribucion.getId()).slash("colaboraciones").withRel("colaboraciones"));
        res.add(linkTo(ListaDistribucionController.class).slash(listaDistribucion.getId()).slash("tareas").slash("asignadas").withRel("tareasAsignadas"));
        res.add(linkTo(ListaDistribucionController.class).slash(listaDistribucion.getId()).slash("subtareas").slash("asignadas").withRel("subtareasAsignadas"));
        if(listaDistribucion.getProyecto() != null)
        {
            res.add((linkTo(ProyectoController.class).slash(listaDistribucion.getProyecto().getId()).withRel("proyecto")));
        }
        return res;
    }
}
