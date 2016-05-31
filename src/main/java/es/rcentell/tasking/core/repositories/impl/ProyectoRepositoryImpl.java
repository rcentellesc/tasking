package es.rcentell.tasking.core.repositories.impl;

import es.rcentell.tasking.core.models.entities.Proyecto;
import es.rcentell.tasking.core.repositories.ProyectoRepository;
import es.rcentell.tasking.core.services.utils.ProyectoList;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Repository
public class ProyectoRepositoryImpl implements ProyectoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Proyecto createProyecto(Proyecto data) {
        em.persist(data);
        return data;
    }

    @Override
    public List<Proyecto> findAllProyectos() {
        Query query = em.createQuery("SELECT b from Proyecto b");
        return query.getResultList();
    }
    @Override
    public Proyecto updateProyecto(Long id, Proyecto data) {
        Proyecto proyecto = em.find(Proyecto.class, id);
        proyecto.setNombre(data.getNombre());
        proyecto.setDescripcion(data.getDescripcion());
        proyecto.setCodigo(data.getCodigo());
        return proyecto;
    }

    @Override
    public Proyecto deleteProyecto(Long id) {
        Proyecto proyecto = em.find(Proyecto.class, id);
        em.remove(proyecto);
        return proyecto;
    }

    @Override
    public Proyecto findProyecto(Long id) {
        return em.find(Proyecto.class, id);
    }

    @Override
    public Proyecto findProyectoByNombre(String nombre) {
        Query query = em.createQuery("SELECT b from Proyecto b where b.nombre=?1");
        query.setParameter(1, nombre);
        List<Proyecto> proyectos = query.getResultList();
        if(proyectos.isEmpty()) {
            return null;
        } else {
            return proyectos.get(0);
        }
    }

    @Override
    public List<Proyecto> findAllProyectosByCreador(Long usuarioId) {
        Query query = em.createQuery("SELECT b from Proyecto b where b.creador.id=?1");
        query.setParameter(1, usuarioId);

        return query.getResultList();
    }
}
