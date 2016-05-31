package es.rcentell.tasking.core.services.utils;

import es.rcentell.tasking.core.models.entities.Subtarea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class SubtareaList {
    private List<Subtarea> subtareas = new ArrayList<Subtarea>();
    private Long tareaId;
    private Long colaboracionId;
    private Long listaDistribucionId;

    public SubtareaList(Long tareaId,Long colaboracionId, Long listaDistribucionId, List<Subtarea> subtareas) {
        this.tareaId = tareaId;
        this.subtareas = subtareas;
        this.colaboracionId=colaboracionId;
        this.listaDistribucionId=listaDistribucionId;
    }

    public List<Subtarea> getSubtareas() {
        return subtareas;
    }

    public void setSubtareas(List<Subtarea> subtareas) {
        this.subtareas = subtareas;
    }

    public Long getTareaId() {
        return tareaId;
    }

    public void setTareaId(Long tareaId) {
        this.tareaId = tareaId;
    }

    public Long getColaboracionId() {
        return colaboracionId;
    }

    public void setColaboracionId(Long colaboracionId) {
        this.colaboracionId = colaboracionId;
    }

    public Long getListaDistribucionId() {
        return listaDistribucionId;
    }

    public void setListaDistribucionId(Long listaDistribucionId) {
        this.listaDistribucionId = listaDistribucionId;
    }
}
