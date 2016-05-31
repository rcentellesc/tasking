package es.rcentell.tasking.core.repositories.impl;

import es.rcentell.tasking.core.models.entities.Usuario;
import es.rcentell.tasking.core.repositories.UsuarioRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Usuario createUsuario(Usuario data) {
        em.persist(data);
        return data;
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        Query query = em.createQuery("SELECT b from Usuario b");
        return query.getResultList();
    }
    @Override
    public Usuario updateUsuario(Long id, Usuario data) {
        Usuario usuario = em.find(Usuario.class, id);
        usuario.setNombre(data.getNombre());
        usuario.setEmail(data.getEmail());
        usuario.setLogin(data.getLogin());
        usuario.setPassword(data.getPassword());
        usuario.setFechaRegistro(data.getFechaRegistro());
        return usuario;
    }

    @Override
    public Usuario deleteUsuario(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        em.remove(usuario);
        return usuario;
    }

    @Override
    public Usuario findUsuario(Long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public Usuario findUsuarioByLogin(String login) {
        Query query = em.createQuery("SELECT b from Usuario where b.login=?1");
        query.setParameter(1, login);
        List<Usuario> usuarios = query.getResultList();
        if(usuarios.isEmpty()) {
            return null;
        } else {
            return usuarios.get(0);
        }
    }

}
