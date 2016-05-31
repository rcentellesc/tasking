package es.rcentell.tasking.core.services;

import es.rcentell.tasking.core.models.entities.ListaDistribucion;
import es.rcentell.tasking.core.models.entities.Proyecto;
import es.rcentell.tasking.core.models.entities.Rol;
import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.core.services.utils.*;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface ProyectoService {

    public Proyecto findProyecto(Long id);

    public Proyecto deleteProyecto(Long id);

    public Proyecto createProyecto(Proyecto  data);

    public Proyecto updateProyecto(Long id, Proyecto data);

    public ProyectoList findAllProyectos();

    public Tarea createTarea(Long proyectoId, Tarea data);

    public Rol createRol(Long proyectoId, Rol data);

    public ListaDistribucion createListaDistribucion(Long proyectoId, ListaDistribucion data);

    public TareaList findAllTareas(Long proyectoId);

    public TareaList findAllTareasDesasignadas(Long proyectoId);

    public RolList findAllRoles(Long proyectoId);

    public ListaDistribucionList findAllListasDistribucion(Long proyectoId);

    public ColaboracionList findAllColaboraciones(Long proyectoId);
}
