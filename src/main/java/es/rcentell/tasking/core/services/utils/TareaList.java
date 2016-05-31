package es.rcentell.tasking.core.services.utils;

import es.rcentell.tasking.core.models.entities.Tarea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class TareaList {
    private List<Tarea> tareas = new ArrayList<Tarea>();
    private Long proyectoId;
    private Long colaboradorId;
    private Long listaDistribucionId;

    public TareaList(Long proyectoId, Long colaboradorId, Long listaDistribucionId,List<Tarea> tareas) {
        this.proyectoId = proyectoId;
        this.tareas = tareas;
        this.colaboradorId=colaboradorId;
        this.listaDistribucionId=listaDistribucionId;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Long getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Long proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Long getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Long colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public Long getListaDistribucionId() {
        return listaDistribucionId;
    }

    public void setListaDistribucionId(Long listaDistribucionId) {
        this.listaDistribucionId = listaDistribucionId;
    }
}
