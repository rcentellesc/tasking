package es.rcentell.tasking.core.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Entity
public class Colaboracion {
    @Id @GeneratedValue
    private Long id;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechaColaboracion;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(foreignKey=@ForeignKey(name="FK_COLABORACION_PROYECTO"))
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(foreignKey=@ForeignKey(name="FK_COLABORACION_USUARIO"))
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="colaboracion_roles",
            joinColumns=@JoinColumn(name="colaboracion_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="rol_id", referencedColumnName="id"),
            foreignKey = @ForeignKey(name = "FK_COLABORACION_ROLES_COLABORACION"),
            inverseForeignKey = @ForeignKey(name = "FK_COLABORACION_ROLES_ROL"))
    private Set<Rol> roles;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaColaboracion() {
        return fechaColaboracion;
    }

    public void setFechaColaboracion(Date fechaColaboracion) {
        this.fechaColaboracion = fechaColaboracion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    @PrePersist
    private void onPersist() {
        this.fechaColaboracion=new Date();

    }
}