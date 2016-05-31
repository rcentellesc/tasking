package es.rcentell.tasking.core.services.impl;

import es.rcentell.tasking.core.models.entities.Colaboracion;
import es.rcentell.tasking.core.models.entities.ListaDistribucion;
import es.rcentell.tasking.core.repositories.ColaboracionRepository;
import es.rcentell.tasking.core.repositories.ListaDistribucionRepository;
import es.rcentell.tasking.core.repositories.SubtareaRepository;
import es.rcentell.tasking.core.repositories.TareaRepository;
import es.rcentell.tasking.core.services.ListaDistribucionService;
import es.rcentell.tasking.core.services.exceptions.AlreadyExistsException.ListaDistribucionAlreadyExistsException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.ListaDistribucionNotFoundException;
import es.rcentell.tasking.core.services.utils.ColaboracionList;
import es.rcentell.tasking.core.services.utils.SubtareaList;
import es.rcentell.tasking.core.services.utils.TareaList;
import es.rcentell.tasking.rest.resources.ColaboracionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Service
@Transactional
public class ListaDistribucionServiceImpl implements ListaDistribucionService{

    @Autowired
    private ListaDistribucionRepository listaDistribucionRepository;
    @Autowired
    private ColaboracionRepository colaboracionRepository;
    @Autowired
    private SubtareaRepository subtareaRepository;
    @Autowired
    private TareaRepository tareaRepository;


    @Override
    public ListaDistribucion findListaDistribucion(Long id) {
        ListaDistribucion listaDistribucion = listaDistribucionRepository.findListaDistribucion(id);
        if(listaDistribucion==null)
        {
            throw new ListaDistribucionNotFoundException();
        }
        else{
            return listaDistribucion;
        }
    }
    @Override
    public ListaDistribucion deleteListaDistribucion(Long id) {
        return listaDistribucionRepository.deleteListaDistribucion(id);
    }

    @Override
    public ListaDistribucion updateListaDistribucion(Long id, ListaDistribucion data) {
        return listaDistribucionRepository.updateListaDistribucion(id, data);
    }

    @Override
    public ColaboracionList findAllColaboraciones(Long listaDistribucionId) {
        ListaDistribucion listaDistribucion= listaDistribucionRepository.findListaDistribucion(listaDistribucionId);
        if(listaDistribucion == null)
        {
            throw new ListaDistribucionNotFoundException();
        }
        return new ColaboracionList(null,null,listaDistribucionId, colaboracionRepository.findByListaDistribucionId(listaDistribucionId));
    }

    @Override
    public SubtareaList findAllSubTareasAsignadas(Long id) {
        ListaDistribucion listaDistribucion = listaDistribucionRepository.findListaDistribucion(id);
        if(listaDistribucion == null)
        {
            throw new ListaDistribucionNotFoundException();
        }
        return new SubtareaList(null,null,id, subtareaRepository.findByAsignacionListaId(id));
    }

    @Override
    public TareaList findAllTareasAsignadas(Long id) {
        ListaDistribucion listaDistribucion = listaDistribucionRepository.findListaDistribucion(id);
        if(listaDistribucion == null)
        {
            throw new ListaDistribucionNotFoundException();
        }
        return new TareaList(null,null,id, tareaRepository.findByAsignacionListaId(id));
    }
}
