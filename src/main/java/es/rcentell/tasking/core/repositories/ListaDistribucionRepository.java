package es.rcentell.tasking.core.repositories;

import es.rcentell.tasking.core.models.entities.ListaDistribucion;
import es.rcentell.tasking.core.models.entities.Rol;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface ListaDistribucionRepository {
    public ListaDistribucion findListaDistribucion(Long id);

    public ListaDistribucion deleteListaDistribucion(Long id);

    public ListaDistribucion updateListaDistribucion(Long id, ListaDistribucion data);

    public ListaDistribucion createListaDistribucion(ListaDistribucion data);

    public List<ListaDistribucion> findByProyectoId(Long proyectoId);

    public List<ListaDistribucion> findByColaboracionId(Long colaboracionId);
}
