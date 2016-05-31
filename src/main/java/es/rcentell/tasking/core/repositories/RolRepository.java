package es.rcentell.tasking.core.repositories;

import es.rcentell.tasking.core.models.entities.Rol;
import es.rcentell.tasking.core.models.entities.Tarea;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface RolRepository {
    public Rol findRol(Long id);

    public Rol deleteRol(Long id);

    public Rol updateRol(Long id, Rol data);

    public Rol createRol(Rol data);

    public List<Rol> findByProyectoId(Long proyectoId);
}
