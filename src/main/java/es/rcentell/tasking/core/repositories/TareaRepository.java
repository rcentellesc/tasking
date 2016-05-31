package es.rcentell.tasking.core.repositories;

import es.rcentell.tasking.core.models.entities.Tarea;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface TareaRepository {
    public Tarea findTarea(Long id);

    public Tarea deleteTarea(Long id);

    public Tarea updateTarea(Long id, Tarea data);

    public Tarea createTarea(Tarea data);

    public List<Tarea> findByProyectoId(Long proyectoId);

    public List<Tarea> findByProyectoIdDesasignadas(Long proyectoId);

    public List<Tarea> findByAsignacionId(Long asignacionId);

    public List<Tarea> findByCreadorId(Long creadorId);

    public List<Tarea> findByAsignacionListaId(Long asignacionListaId);
}
