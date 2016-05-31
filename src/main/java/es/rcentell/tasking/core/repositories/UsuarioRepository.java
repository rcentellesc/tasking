package es.rcentell.tasking.core.repositories;

import es.rcentell.tasking.core.models.entities.Usuario;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public interface UsuarioRepository {
    public Usuario createUsuario(Usuario data);
    public List<Usuario> findAllUsuarios();
    public Usuario findUsuarioByLogin(String login);
    public Usuario findUsuario(Long id);
    public Usuario deleteUsuario(Long id);
    public Usuario updateUsuario(Long id, Usuario data);
}
