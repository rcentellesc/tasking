package es.rcentell.tasking.core.services.utils;

import es.rcentell.tasking.core.models.entities.ListaDistribucion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ListaDistribucionList {
    private List<ListaDistribucion> listasDistribucion = new ArrayList<ListaDistribucion>();
    private Long proyectoId;

    public ListaDistribucionList(Long proyectoId, List<ListaDistribucion> listasDistribucion) {
        this.proyectoId = proyectoId;
        this.listasDistribucion = listasDistribucion;
    }

    public List<ListaDistribucion> getListasDistribucion() {
        return listasDistribucion;
    }

    public void setListasDistribucion(List<ListaDistribucion> listasDistribucion) {
        this.listasDistribucion = listasDistribucion;
    }

    public Long getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Long proyectoId) {
        this.proyectoId = proyectoId;
    }
}
