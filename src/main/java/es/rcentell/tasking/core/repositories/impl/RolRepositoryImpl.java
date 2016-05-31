package es.rcentell.tasking.core.repositories.impl;

import es.rcentell.tasking.core.models.entities.Rol;
import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.core.repositories.RolRepository;
import es.rcentell.tasking.core.repositories.TareaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Repository
public class RolRepositoryImpl implements RolRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Rol findRol(Long id) {
        return em.find(Rol.class,id);
    }

    @Override
    public Rol deleteRol(Long id) {
        Rol rol = em.find(Rol.class, id);
        em.remove(rol);
        return rol;
    }

    @Override
    public Rol updateRol(Long id, Rol data) {
        Rol rol = em.find(Rol.class, id);
        rol.setNombre(data.getNombre());
        rol.setDescripcion(data.getDescripcion());
        rol.setIndEdicion(data.getIndEdicion());
        return rol;
    }
    @Override
    public Rol createRol(Rol data) {
        em.persist(data);
        return data;
    }

    @Override
    public List<Rol> findByProyectoId(Long proyectoId) {
        Query query = em.createQuery("SELECT b FROM Rol b WHERE b.proyecto.id=?1");
        query.setParameter(1, proyectoId);
        return query.getResultList();
    }
}
