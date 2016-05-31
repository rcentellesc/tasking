package es.rcentell.tasking.core.repositories;

import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.models.entities.Tarea;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface ComentarioRepository {
    public Comentario findComentario(Long id);

    public Comentario deleteComentario(Long id);

    public Comentario updateComentario(Long id, Comentario data);

    public Comentario createComentario(Comentario data);

    public List<Comentario> findByTareaId(Long tareaId);

    public List<Comentario> findBySubtareaId(Long subtareaId);
}
