package es.rcentell.tasking.core.services.impl;

import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.models.entities.Subtarea;
import es.rcentell.tasking.core.repositories.ComentarioRepository;
import es.rcentell.tasking.core.repositories.SubtareaRepository;
import es.rcentell.tasking.core.services.SubtareaService;
import es.rcentell.tasking.core.services.exceptions.AlreadyExistsException.SubtareaAlreadyExistsException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.SubtareaNotFoundException;
import es.rcentell.tasking.core.services.utils.ComentarioList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Service
@Transactional
public class SubtareaServiceImpl implements SubtareaService {

    @Autowired
    private SubtareaRepository subtareaRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public Comentario createComentario(Long subtareaId, Comentario data) {
        Subtarea subtarea= subtareaRepository.findSubtarea(subtareaId);
        if(subtarea == null)
        {
            throw new SubtareaNotFoundException();
        }
        Comentario comentario = comentarioRepository.createComentario(data);
        comentario.setSubtarea(subtarea);
        return comentario;
    }
    @Override
    public Subtarea findSubtarea(Long id) {
        Subtarea subtarea = subtareaRepository.findSubtarea(id);
        if(subtarea==null)
        {
            throw new SubtareaNotFoundException();
        }
        else{
            return subtarea;
        }
    }
    @Override
    public Subtarea deleteSubtarea(Long id) {
        return subtareaRepository.deleteSubtarea(id);
    }

    @Override
    public Subtarea updateSubtarea(Long id, Subtarea data) {
        return subtareaRepository.updateSubtarea(id, data);
    }

    @Override
    public ComentarioList findAllComentarios(Long subtareaId) {
        Subtarea subtarea=subtareaRepository.findSubtarea(subtareaId);
        if(subtarea == null)
        {
            throw new SubtareaNotFoundException();
        }
        return new ComentarioList(subtareaId,null,comentarioRepository.findByTareaId(subtareaId));
    }

}
