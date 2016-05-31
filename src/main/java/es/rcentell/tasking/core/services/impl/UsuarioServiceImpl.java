package es.rcentell.tasking.core.services.impl;

import es.rcentell.tasking.core.models.entities.Proyecto;
import es.rcentell.tasking.core.models.entities.Usuario;
import es.rcentell.tasking.core.repositories.ColaboracionRepository;
import es.rcentell.tasking.core.repositories.ProyectoRepository;
import es.rcentell.tasking.core.repositories.UsuarioRepository;
import es.rcentell.tasking.core.services.UsuarioService;
import es.rcentell.tasking.core.services.exceptions.AlreadyExistsException.UsuarioAlreadyExistsException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.ProyectoNotFoundException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.UsuarioNotFoundException;
import es.rcentell.tasking.core.services.utils.ColaboracionList;
import es.rcentell.tasking.core.services.utils.ProyectoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ColaboracionRepository colaboracionRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public Usuario findUsuario(Long id) {
        Usuario usuario = usuarioRepository.findUsuario(id);
        if(usuario==null)
        {
            throw new UsuarioNotFoundException();
        }
        else{
            return usuario;
        }
    }

    @Override
    public Usuario createUsuario(Usuario data) {
        Usuario usuario = usuarioRepository.createUsuario(data);
        return usuario;
    }


    @Override
    public Usuario deleteUsuario(Long id) {
        return usuarioRepository.deleteUsuario(id);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario data) {
        return usuarioRepository.updateUsuario(id, data);
    }

    @Override
    public ColaboracionList findAllColaboraciones(Long usuarioId) {
        Usuario usuario= usuarioRepository.findUsuario(usuarioId);
        if(usuario == null)
        {
            throw new UsuarioNotFoundException();
        }
        return new ColaboracionList(usuarioId,null,null, colaboracionRepository.findByUsuarioId(usuarioId));
    }
    @Override
    public ProyectoList findAllProyectosByCreador(Long usuarioId) {
        Usuario usuario= usuarioRepository.findUsuario(usuarioId);
        if(usuario == null)
        {
            throw new UsuarioNotFoundException();
        }
        return new ProyectoList(usuarioId, proyectoRepository.findAllProyectosByCreador(usuarioId));
    }
}
