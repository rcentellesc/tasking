package es.rcentell.tasking.core.repositories.impl;

import es.rcentell.tasking.core.models.entities.ListaDistribucion;
import es.rcentell.tasking.core.repositories.ListaDistribucionRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Repository
public class ListaDistribucionRepositoryImpl implements ListaDistribucionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ListaDistribucion findListaDistribucion(Long id) {
        return em.find(ListaDistribucion.class,id);
    }

    @Override
    public ListaDistribucion deleteListaDistribucion(Long id) {
        ListaDistribucion listaDistribucion = em.find(ListaDistribucion.class, id);
        em.remove(listaDistribucion);
        return listaDistribucion;
    }

    @Override
    public ListaDistribucion updateListaDistribucion(Long id, ListaDistribucion data) {
        ListaDistribucion listaDistribucion = em.find(ListaDistribucion.class, id);
        listaDistribucion.setNombre(data.getNombre());
        listaDistribucion.setDescripcion(data.getDescripcion());
        listaDistribucion.setColaboraciones(data.getColaboraciones());
        return listaDistribucion;
    }
    @Override
    public ListaDistribucion createListaDistribucion(ListaDistribucion data) {
        em.persist(data);
        return data;
    }

    @Override
    public List<ListaDistribucion> findByProyectoId(Long proyectoId) {
        Query query = em.createQuery("SELECT b FROM ListaDistribucion b WHERE b.proyecto.id=?1");
        query.setParameter(1, proyectoId);
        return query.getResultList();
    }
    @Override
    public List<ListaDistribucion> findByColaboracionId(Long colaboracionId) {
        Query query = em.createQuery("SELECT b FROM ListaDistribucion b JOIN b.colaboraciones c " +
                "WHERE c.id=?1");
        query.setParameter(1, colaboracionId);
        return query.getResultList();
    }
}
