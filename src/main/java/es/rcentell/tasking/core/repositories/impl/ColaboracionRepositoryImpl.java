package es.rcentell.tasking.core.repositories.impl;

import es.rcentell.tasking.core.models.entities.Colaboracion;
import es.rcentell.tasking.core.repositories.ColaboracionRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Repository
public class ColaboracionRepositoryImpl implements ColaboracionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Colaboracion findColaboracion(Long id) {
        return em.find(Colaboracion.class,id);
    }

    @Override
    public Colaboracion deleteColaboracion(Long id) {
        Colaboracion colaboracion = em.find(Colaboracion.class, id);
        em.remove(colaboracion);
        return colaboracion;
    }

    @Override
    public Colaboracion updateColaboracion(Long id, Colaboracion data) {
        Colaboracion colaboracion = em.find(Colaboracion.class, id);
        colaboracion.setFechaColaboracion(data.getFechaColaboracion());
        colaboracion.setRoles(data.getRoles());
        return colaboracion;
    }

    @Override
    public Colaboracion createColaboracion(Colaboracion data) {
        em.persist(data);
        return data;
    }

    @Override
    public List<Colaboracion> findByProyectoId(Long proyectoId) {
        Query query = em.createQuery("SELECT b FROM Colaboracion b WHERE b.proyecto.id=?1");
        query.setParameter(1, proyectoId);
        return query.getResultList();
    }
    @Override
    public List<Colaboracion> findByUsuarioId(Long usuarioId) {
        Query query = em.createQuery("SELECT b FROM Colaboracion b WHERE b.usuario.id=?1");
        query.setParameter(1, usuarioId);
        return query.getResultList();
    }
    @Override
    public List<Colaboracion> findByListaDistribucionId(Long listaDistribucionId) {
        Query query = em.createQuery("SELECT b.colaboraciones FROM ListaDistribucion b WHERE b.id=?1");
        query.setParameter(1, listaDistribucionId);
        return query.getResultList();
    }
}
