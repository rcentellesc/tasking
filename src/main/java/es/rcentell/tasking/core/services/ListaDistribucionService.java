package es.rcentell.tasking.core.services;

import es.rcentell.tasking.core.models.entities.ListaDistribucion;
import es.rcentell.tasking.core.services.utils.ColaboracionList;
import es.rcentell.tasking.core.services.utils.SubtareaList;
import es.rcentell.tasking.core.services.utils.TareaList;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface ListaDistribucionService {

    public ListaDistribucion findListaDistribucion(Long id);

    public ListaDistribucion deleteListaDistribucion(Long id);

    public ListaDistribucion updateListaDistribucion(Long id, ListaDistribucion data);

    public ColaboracionList findAllColaboraciones(Long listaDistribucionId);

    public TareaList findAllTareasAsignadas(Long id);

    public SubtareaList findAllSubTareasAsignadas(Long id);

}
