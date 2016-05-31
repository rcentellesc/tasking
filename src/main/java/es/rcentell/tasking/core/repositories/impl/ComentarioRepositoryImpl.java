package es.rcentell.tasking.core.repositories.impl;

import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.core.repositories.ComentarioRepository;
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
public class ComentarioRepositoryImpl implements ComentarioRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Comentario findComentario(Long id) {
        return em.find(Comentario.class,id);
    }

    @Override
    public Comentario deleteComentario(Long id) {
        Comentario comentario = em.find(Comentario.class, id);
        em.remove(comentario);
        return comentario;
    }

    @Override
    public Comentario updateComentario(Long id, Comentario data) {
        Comentario comentario = em.find(Comentario.class, id);
        comentario.setComentario(data.getComentario());
        comentario.setFechaCreacion(data.getFechaCreacion());
        return comentario;
    }

    @Override
    public Comentario createComentario(Comentario data) {
        em.persist(data);
        return data;
    }

    @Override
    public List<Comentario> findByTareaId(Long tareaId) {
        Query query = em.createQuery("SELECT b FROM Comentario b WHERE b.tarea.id=?1");
        query.setParameter(1, tareaId);
        return query.getResultList();
    }

    @Override
    public List<Comentario> findBySubtareaId(Long subtareaId) {
        Query query = em.createQuery("SELECT b FROM Comentario b WHERE b.subtarea.id=?1");
        query.setParameter(1, subtareaId);
        return query.getResultList();
    }
}
