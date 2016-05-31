package es.rcentell.tasking.core.repositories;

import es.rcentell.tasking.core.models.entities.Subtarea;
import es.rcentell.tasking.core.models.entities.Tarea;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface SubtareaRepository {
    public Subtarea findSubtarea(Long id);

    public Subtarea deleteSubtarea(Long id);

    public Subtarea updateSubtarea(Long id, Subtarea data);

    public Subtarea createSubtarea(Subtarea data);

    public List<Subtarea> findByTareaId(Long tareaId);

    public List<Subtarea> findByTareaIdDesasignadas(Long tareaId);

    public List<Subtarea> findByAsignacionId(Long asignacionId);

    public List<Subtarea> findByCreadorId(Long creadorId);

    public List<Subtarea> findByAsignacionListaId(Long asignacionListaId);
}
