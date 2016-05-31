package es.rcentell.tasking.core.services.impl;

import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.repositories.ComentarioRepository;
import es.rcentell.tasking.core.services.ComentarioService;
import es.rcentell.tasking.core.services.exceptions.AlreadyExistsException.ComentarioAlreadyExistsException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.ComentarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;


    @Override
    public Comentario findComentario(Long id) {
        Comentario comentario = comentarioRepository.findComentario(id);
        if(comentario==null)
        {
            throw new ComentarioNotFoundException();
        }
        else{
            return comentario;
        }
    }
    @Override
    public Comentario deleteComentario(Long id) {
        return comentarioRepository.deleteComentario(id);
    }

    @Override
    public Comentario updateComentario(Long id, Comentario data) {
        return comentarioRepository.updateComentario(id, data);
    }


}
