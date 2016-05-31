package es.rcentell.tasking.rest.resources;

import es.rcentell.tasking.core.models.entities.Tarea;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class TareaResource extends ResourceSupport {

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

    public Tarea toTarea() {
        Tarea tarea= new Tarea();
        tarea.setNombre(nombre);
        tarea.setDescripcion(descripcion);
        tarea.setEstado(estado);
        tarea.setFechaActualizacion(fechaActualizacion);
        tarea.setFechaCreacion(fechaCreacion);
        tarea.setFechaLimite(fechaLimite);
        tarea.setTipo(tipo);
        return tarea;
    }
}
