package es.rcentell.tasking.core.repositories;

import es.rcentell.tasking.core.models.entities.Proyecto;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface ProyectoRepository {
    public Proyecto createProyecto(Proyecto data);
    public List<Proyecto> findAllProyectos();
    public Proyecto findProyectoByNombre(String nombre);
    public Proyecto findProyecto(Long id);
    public Proyecto deleteProyecto(Long id);
    public Proyecto updateProyecto(Long id, Proyecto data);
    public List<Proyecto> findAllProyectosByCreador(Long usuarioId);
}
