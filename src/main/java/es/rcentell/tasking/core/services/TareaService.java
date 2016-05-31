package es.rcentell.tasking.core.services;

import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.models.entities.Subtarea;
import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.core.services.utils.ComentarioList;
import es.rcentell.tasking.core.services.utils.SubtareaList;
import es.rcentell.tasking.core.services.utils.TareaList;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface TareaService {
    public Comentario createComentario(Long tareaId, Comentario data);

    public Subtarea createSubtarea(Long tareaId, Subtarea  data);

    public Tarea findTarea(Long id);

    public Tarea deleteTarea(Long id);

    public Tarea updateTarea(Long id, Tarea data);

    public ComentarioList findAllComentarios(Long tareaId);

    public SubtareaList findAllSubtareas(Long tareaId);

    public SubtareaList findAllSubtareasDesasignadas(Long tareaId);

}
