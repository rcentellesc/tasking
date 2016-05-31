package es.rcentell.tasking.core.models.entities;

import javax.persistence.*;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Entity
public class Proyecto {
    @Id @GeneratedValue
    private Long id;
    private String nombre;
    private String codigo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(foreignKey=@ForeignKey(name="FK_PROYECTO_CREADOR"))
    private Usuario creador;


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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }
}