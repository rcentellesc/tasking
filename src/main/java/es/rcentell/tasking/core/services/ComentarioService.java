package es.rcentell.tasking.core.services;

import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.services.utils.ComentarioList;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface ComentarioService {
    public Comentario findComentario(Long id);

    public Comentario deleteComentario(Long id);

    public Comentario updateComentario(Long id, Comentario data);


}
