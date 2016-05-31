package es.rcentell.tasking.core.repositories.impl;

import es.rcentell.tasking.core.models.entities.Subtarea;
import es.rcentell.tasking.core.repositories.SubtareaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Repository
public class SubtareaRepositoryImpl implements SubtareaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Subtarea findSubtarea(Long id) {
        return em.find(Subtarea.class,id);
    }

    @Override
    public Subtarea deleteSubtarea(Long id) {
        Subtarea subtarea = em.find(Subtarea.class, id);
        em.remove(subtarea);
        return subtarea;
    }

    @Override
    public Subtarea updateSubtarea(Long id, Subtarea data) {
        Subtarea subtarea = em.find(Subtarea.class, id);
        subtarea.setNombre(data.getNombre());
        subtarea.setDescripcion(data.getDescripcion());
        subtarea.setEstado(data.getEstado());
        subtarea.setFechaActualizacion(data.getFechaActualizacion());
        subtarea.setFechaCreacion(data.getFechaCreacion());
        subtarea.setFechaLimite(data.getFechaLimite());
        subtarea.setTipo(data.getTipo());
        return subtarea;
    }

    @Override
    public Subtarea createSubtarea(Subtarea data) {
        em.persist(data);
        return data;
    }

    @Override
    public List<Subtarea> findByTareaId(Long tareaId) {
        Query query = em.createQuery("SELECT b FROM Subtarea b WHERE b.tarea.id=?1");
        query.setParameter(1, tareaId);
        return query.getResultList();
    }
    @Override
    public List<Subtarea> findByTareaIdDesasignadas(Long proyectoId) {
        Query query = em.createQuery("SELECT b FROM Subtarea b WHERE b.tarea.id=?1 AND b.asignacion is null");
        query.setParameter(1, proyectoId);
        return query.getResultList();
    }
    @Override
    public List<Subtarea> findByAsignacionId(Long asignacionId) {
        Query query = em.createQuery("SELECT b FROM Subtarea b WHERE b.asignacion.id=?1");
        query.setParameter(1,asignacionId);
        return query.getResultList();
    }

    @Override
    public List<Subtarea> findByCreadorId(Long creadorId) {
        Query query = em.createQuery("SELECT b FROM Subtarea b WHERE b.creador.id=?1");
        query.setParameter(1,creadorId);
        return query.getResultList();
    }

    @Override
    public List<Subtarea> findByAsignacionListaId(Long asignacionListaId) {
        Query query = em.createQuery("SELECT b FROM Subtarea b WHERE b.asignacionLista.id=?1");
        query.setParameter(1,asignacionListaId);
        return query.getResultList();
    }
}
