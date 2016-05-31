package es.rcentell.tasking.core.services.utils;

import es.rcentell.tasking.core.models.entities.Colaboracion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ColaboracionList {
    private List<Colaboracion> colaboraciones = new ArrayList<Colaboracion>();
    private Long proyectoId;
    private Long usuarioId;
    private Long listaDistribucionId;

    public ColaboracionList(Long usuarioId,Long proyectoId, Long listaDistribucionId, List<Colaboracion> colaboraciones) {
        this.usuarioId=usuarioId;
        this.proyectoId = proyectoId;
        this.colaboraciones = colaboraciones;
        this.listaDistribucionId=listaDistribucionId;
    }

    public List<Colaboracion> getColaboraciones() {
        return colaboraciones;
    }

    public void setColaboraciones(List<Colaboracion> colaboraciones) {
        this.colaboraciones = colaboraciones;
    }

    public Long getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Long proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getListaDistribucionId() {
        return listaDistribucionId;
    }

    public void setListaDistribucionId(Long listaDistribucionId) {
        this.listaDistribucionId = listaDistribucionId;
    }
}
