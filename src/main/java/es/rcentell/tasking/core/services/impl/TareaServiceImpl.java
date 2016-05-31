package es.rcentell.tasking.core.services.impl;

import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.models.entities.Subtarea;
import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.core.repositories.ComentarioRepository;
import es.rcentell.tasking.core.repositories.SubtareaRepository;
import es.rcentell.tasking.core.repositories.TareaRepository;
import es.rcentell.tasking.core.services.TareaService;
import es.rcentell.tasking.core.services.exceptions.AlreadyExistsException.TareaAlreadyExistsException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.TareaNotFoundException;
import es.rcentell.tasking.core.services.utils.ComentarioList;
import es.rcentell.tasking.core.services.utils.SubtareaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Service
@Transactional
public class TareaServiceImpl implements TareaService{

    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private SubtareaRepository subtareaRepository;



    @Override
    public Tarea findTarea(Long id) {
        Tarea tarea = tareaRepository.findTarea(id);
        if(tarea==null)
        {
            throw new TareaNotFoundException();
        }
        else{
            return tarea;
        }
    }
    @Override
    public Comentario createComentario(Long tareaId, Comentario data) {
        Tarea tarea= tareaRepository.findTarea(tareaId);
        if(tarea == null)
        {
            throw new TareaNotFoundException();
        }
        Comentario comentario = comentarioRepository.createComentario(data);
        comentario.setTarea(tarea);
        return comentario;
    }
    @Override
    public Subtarea createSubtarea(Long tareaId, Subtarea data) {
        Tarea tarea= tareaRepository.findTarea(tareaId);
        if(tarea == null)
        {
            throw new TareaNotFoundException();
        }
        Subtarea subtarea = subtareaRepository.createSubtarea(data);
        subtarea.setTarea(tarea);
        return subtarea;
    }
    @Override
    public Tarea deleteTarea(Long id) {
        return tareaRepository.deleteTarea(id);
    }

    @Override
    public Tarea updateTarea(Long id, Tarea data) {
        return tareaRepository.updateTarea(id, data);
    }

    @Override
    public ComentarioList findAllComentarios(Long tareaId) {
        Tarea tarea=tareaRepository.findTarea(tareaId);
        if(tarea == null)
        {
            throw new TareaNotFoundException();
        }
        return new ComentarioList(null,tareaId,comentarioRepository.findByTareaId(tareaId));
    }

    @Override
    public SubtareaList findAllSubtareas(Long tareaId) {
        Tarea tarea=tareaRepository.findTarea(tareaId);
        if(tarea == null)
        {
            throw new TareaNotFoundException();
        }
        return new SubtareaList(tareaId,null,null,subtareaRepository.findByTareaId(tareaId));
    }

    @Override
    public SubtareaList findAllSubtareasDesasignadas(Long tareaId) {
        Tarea tarea=tareaRepository.findTarea(tareaId);
        if(tarea == null)
        {
            throw new TareaNotFoundException();
        }
        return new SubtareaList(tareaId,null,null,subtareaRepository.findByTareaIdDesasignadas(tareaId));
    }

}
