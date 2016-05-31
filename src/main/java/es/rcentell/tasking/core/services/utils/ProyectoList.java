package es.rcentell.tasking.core.services.utils;

import es.rcentell.tasking.core.models.entities.Proyecto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ProyectoList {
    private List<Proyecto> proyectos = new ArrayList<Proyecto>();
    private Long usuarioId;

    public ProyectoList(Long usuarioId, List resultList) {

        this.proyectos = resultList;
        this.usuarioId=usuarioId;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
