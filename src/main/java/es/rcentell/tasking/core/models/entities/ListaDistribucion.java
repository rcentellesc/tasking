package es.rcentell.tasking.core.models.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Entity
@Table(name = "lista_distribucion")
public class ListaDistribucion {
    @Id @GeneratedValue
    private Long id;
    private String descripcion;
    private String nombre;

    @ManyToOne
    @JoinColumn(foreignKey=@ForeignKey(name="FK_LISTAS_PROYECTO"))
    private Proyecto proyecto;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="lista_distribucion_colaboraciones",
            joinColumns=@JoinColumn(name="lista_distribucion_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="colaboracion_id", referencedColumnName="id"),
            foreignKey = @ForeignKey(name = "FK_LISTA_COLABORACIONES_LISTA"),
            inverseForeignKey = @ForeignKey(name = "FK_LISTA_COLABORACIONES_COLABORACION"))
    private Set<Colaboracion> colaboraciones;

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

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Set<Colaboracion> getColaboraciones() {
        return colaboraciones;
    }

    public void setColaboraciones(Set<Colaboracion> colaboraciones) {
        this.colaboraciones = colaboraciones;
    }
}