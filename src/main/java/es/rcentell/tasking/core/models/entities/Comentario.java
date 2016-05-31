package es.rcentell.tasking.core.models.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Entity
public class Comentario {
    @Id @GeneratedValue
    private Long id;
    private String comentario;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(foreignKey=@ForeignKey(name="FK_COMENTARIO_CREADOR"))
    private Colaboracion creador;

    @ManyToOne
    @JoinColumn(foreignKey=@ForeignKey(name="FK_COMENTARIO_TAREA"))
    private Tarea tarea;

    @ManyToOne
    @JoinColumn(foreignKey=@ForeignKey(name="FK_COMENTARIO_SUBTAREA"))
    private Subtarea subtarea;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Subtarea getSubtarea() {
        return subtarea;
    }

    public void setSubtarea(Subtarea subtarea) {
        this.subtarea = subtarea;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Colaboracion getCreador() {
        return creador;
    }

    public void setCreador(Colaboracion creador) {
        this.creador = creador;
    }

    @PrePersist
    private void onPersist() {
        this.fechaCreacion=new Date();

    }
}