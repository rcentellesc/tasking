package es.rcentell.tasking.core.models.entities;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Entity
public class Subtarea {
    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private String descripcion;
    @Column(columnDefinition="INT DEFAULT 0")
    private int tipo;
    @Column(columnDefinition="INT DEFAULT 0")
    private int estado;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechaCreacion;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechaActualizacion;
    private Date fechaLimite;

    @ManyToOne
    @JoinColumn(foreignKey=@ForeignKey(name="FK_SUBTAREA_TAREA"))
    private Tarea tarea;
    @ManyToOne
    @JoinColumn(foreignKey=@ForeignKey(name="FK_SUBTAREA_CREADOR"))
    private Colaboracion creador;
    @ManyToOne
    @JoinColumn(foreignKey=@ForeignKey(name="FK_SUBTAREA_ASIGNACION"))
    private Colaboracion asignacion;
    @ManyToOne
    @JoinColumn(name="asignacion_lista",foreignKey=@ForeignKey(name="FK_SUBTAREA_ASIGNACION_LISTA"))
    private ListaDistribucion asignacionLista;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
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

    public Colaboracion getCreador() {
        return creador;
    }

    public void setCreador(Colaboracion creador) {
        this.creador = creador;
    }

    public Colaboracion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Colaboracion asignacion) {
        this.asignacion = asignacion;
    }

    public ListaDistribucion getAsignacionLista() {
        return asignacionLista;
    }

    public void setAsignacionLista(ListaDistribucion asignacionLista) {
        this.asignacionLista = asignacionLista;
    }

    @PrePersist
    private void onPersist() {
        this.fechaCreacion=new Date();

    }
    @PreUpdate
    private void onUpdate() {
        this.fechaActualizacion=new Date();

    }

}