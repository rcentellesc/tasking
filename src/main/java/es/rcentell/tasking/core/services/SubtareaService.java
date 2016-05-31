package es.rcentell.tasking.core.services;

import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.models.entities.Subtarea;
import es.rcentell.tasking.core.services.utils.ComentarioList;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface SubtareaService {
    public Comentario createComentario(Long subtareaId, Comentario data);

    public Subtarea findSubtarea(Long id);

    public Subtarea deleteSubtarea(Long id);

    public Subtarea updateSubtarea(Long id, Subtarea data);

    public ComentarioList findAllComentarios(Long subtareaId);
}
