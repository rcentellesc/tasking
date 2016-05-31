package es.rcentell.tasking.core.repositories.impl;

import es.rcentell.tasking.core.models.entities.Tarea;
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
public class TareaRepositoryImpl implements TareaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Tarea findTarea(Long id) {
        return em.find(Tarea.class,id);
    }

    @Override
    public Tarea deleteTarea(Long id) {
        Tarea tarea = em.find(Tarea.class, id);
        em.remove(tarea);
        return tarea;
    }

    @Override
    public Tarea updateTarea(Long id, Tarea data) {
        Tarea tarea = em.find(Tarea.class, id);
        tarea.setNombre(data.getNombre());
        tarea.setDescripcion(data.getDescripcion());
        tarea.setEstado(data.getEstado());
        tarea.setFechaActualizacion(data.getFechaActualizacion());
        tarea.setFechaCreacion(data.getFechaCreacion());
        tarea.setFechaLimite(data.getFechaLimite());
        tarea.setTipo(data.getTipo());
        return tarea;
    }

    @Override
    public Tarea createTarea(Tarea data) {
        em.persist(data);
        return data;
    }

    @Override
    public List<Tarea> findByProyectoId(Long proyectoId) {
        Query query = em.createQuery("SELECT b FROM Tarea b WHERE b.proyecto.id=?1");
        query.setParameter(1, proyectoId);
        return query.getResultList();
    }
    @Override
    public List<Tarea> findByProyectoIdDesasignadas(Long proyectoId) {
        Query query = em.createQuery("SELECT b FROM Tarea b WHERE b.proyecto.id=?1 AND b.asignacion is null");
        query.setParameter(1, proyectoId);
        return query.getResultList();
    }
    @Override
    public List<Tarea> findByAsignacionId(Long asignacionId) {
        Query query = em.createQuery("SELECT b FROM Tarea b WHERE b.asignacion.id=?1");
        query.setParameter(1,asignacionId);
        return query.getResultList();
    }

    @Override
    public List<Tarea> findByCreadorId(Long creadorId) {
        Query query = em.createQuery("SELECT b FROM Tarea b WHERE b.creador.id=?1");
        query.setParameter(1,creadorId);
        return query.getResultList();
    }

    @Override
    public List<Tarea> findByAsignacionListaId(Long asignacionListaId) {
        Query query = em.createQuery("SELECT b FROM Tarea b WHERE b.asignacionLista.id=?1");
        query.setParameter(1,asignacionListaId);
        return query.getResultList();
    }
}
