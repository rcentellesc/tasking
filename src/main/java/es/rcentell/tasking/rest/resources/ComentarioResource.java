package es.rcentell.tasking.rest.resources;

import es.rcentell.tasking.core.models.entities.Comentario;
import es.rcentell.tasking.core.models.entities.Tarea;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ComentarioResource extends ResourceSupport {

    private String comentario;
    private Date fechaCreacion;
    private Date fechaActualizacion;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Comentario toComentario() {
        Comentario coment= new Comentario();
        coment.setComentario(comentario);
        coment.setFechaCreacion(fechaCreacion);
        return coment;
    }
}
