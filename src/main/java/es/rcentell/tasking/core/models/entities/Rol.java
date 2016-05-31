package es.rcentell.tasking.core.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Entity
public class Rol {
    @Id @GeneratedValue
    private Long id;
    private String descripcion;
    private String nombre;
    @Column(name="ind_edicion",columnDefinition="INT DEFAULT 0")
    private int indEdicion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(foreignKey=@ForeignKey(name="FK_ROLES_PROYECTO"))
    private Proyecto proyecto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIndEdicion() {
        return indEdicion;
    }

    public void setIndEdicion(int indEdicion) {
        this.indEdicion = indEdicion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}