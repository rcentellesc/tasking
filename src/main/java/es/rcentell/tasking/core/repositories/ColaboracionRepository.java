package es.rcentell.tasking.core.repositories;

import es.rcentell.tasking.core.models.entities.Colaboracion;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface ColaboracionRepository {
    public Colaboracion findColaboracion(Long id);

    public Colaboracion deleteColaboracion(Long id);

    public Colaboracion updateColaboracion(Long id, Colaboracion data);

    public Colaboracion createColaboracion(Colaboracion data);

    public List<Colaboracion> findByProyectoId(Long proyectoId);

    public List<Colaboracion> findByUsuarioId(Long usuarioId);

    public List<Colaboracion> findByListaDistribucionId(Long listaDistribucionId);
}
