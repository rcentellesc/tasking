package es.rcentell.tasking.core.services;

import es.rcentell.tasking.core.models.entities.Usuario;
import es.rcentell.tasking.core.services.utils.ColaboracionList;
import es.rcentell.tasking.core.services.utils.ProyectoList;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface UsuarioService {
    public Usuario createUsuario(Usuario data);

    public Usuario findUsuario (Long id);

    public Usuario deleteUsuario(Long id);

    public Usuario updateUsuario(Long id, Usuario data);

    public ColaboracionList findAllColaboraciones(Long usuarioId);

    public ProyectoList findAllProyectosByCreador(Long usuarioId);
}

