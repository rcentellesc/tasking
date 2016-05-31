package es.rcentell.tasking.core.services;

import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.models.entities.Rol;
import es.rcentell.tasking.core.models.entities.Subtarea;
import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.core.services.utils.ComentarioList;
import es.rcentell.tasking.core.services.utils.SubtareaList;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface RolService {

    public Rol findRol(Long id);

    public Rol deleteRol(Long id);

    public Rol updateRol(Long id, Rol data);

}
