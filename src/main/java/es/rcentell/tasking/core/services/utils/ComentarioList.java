package es.rcentell.tasking.core.services.utils;

import es.rcentell.tasking.core.models.entities.Comentario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ComentarioList {
    private List<Comentario> comentarios = new ArrayList<Comentario>();
    private Long tareaId;
    private Long subtareaId;

    public ComentarioList(Long subtareaId, Long tareaId, List<Comentario> comentarios) {
        this.subtareaId=subtareaId;
        this.tareaId = tareaId;
        this.comentarios = comentarios;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Long getTareaId() {
        return tareaId;
    }

    public void setTareaId(Long tareaId) {
        this.tareaId = tareaId;
    }

    public Long getSubtareaId() {
        return subtareaId;
    }

    public void setSubtareaId(Long subtareaId) {
        this.subtareaId = subtareaId;
    }
}
