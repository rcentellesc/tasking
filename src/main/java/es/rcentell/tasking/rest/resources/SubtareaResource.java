package es.rcentell.tasking.rest.resources;

import es.rcentell.tasking.core.models.entities.Subtarea;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class SubtareaResource extends ResourceSupport {

    private String nombre;
    private String descripcion;
    private int tipo;
    private int estado;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private Date fechaLimite;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Subtarea toSubtarea() {
        Subtarea subtarea = new Subtarea();
        subtarea.setNombre(nombre);
        subtarea.setDescripcion(descripcion);
        subtarea.setEstado(estado);
        subtarea.setFechaActualizacion(fechaActualizacion);
        subtarea.setFechaCreacion(fechaCreacion);
        subtarea.setFechaLimite(fechaLimite);
        subtarea.setTipo(tipo);
        return subtarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
}
