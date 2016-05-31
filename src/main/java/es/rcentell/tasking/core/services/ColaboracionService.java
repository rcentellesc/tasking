package es.rcentell.tasking.core.services;

import es.rcentell.tasking.core.models.entities.Colaboracion;
import es.rcentell.tasking.core.services.utils.ListaDistribucionList;
import es.rcentell.tasking.core.services.utils.SubtareaList;
import es.rcentell.tasking.core.services.utils.TareaList;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface ColaboracionService {

    public Colaboracion createColaboracion(Long proyectoId, Long usuarioId, Colaboracion data);

    public Colaboracion findColaboracion(Long id);

    public Colaboracion deleteColaboracion(Long id);

    public Colaboracion updateColaboracion(Long id, Colaboracion data);

    public ListaDistribucionList findAllListasDistribucion(Long colaboracionId);

    public TareaList findAllTareasCreadas(Long id);

    public TareaList findAllTareasAsiganadas(Long id);

    public SubtareaList findAllSubtareasCreadas(Long id);

    public SubtareaList findAllSubtareasAsiganadas(Long id);

}
