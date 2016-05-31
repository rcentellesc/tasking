package es.rcentell.tasking.rest.resources.mapper;

import es.rcentell.tasking.core.models.entities.Colaboracion;
import es.rcentell.tasking.core.models.entities.Proyecto;
import es.rcentell.tasking.core.models.entities.Usuario;
import es.rcentell.tasking.rest.resources.ColaboracionResource;

/**
 * Created by Rcentell on 31/05/2016.
 */
public class ColaboracionMapper {
    private Long usuario;
    private Long proyecto;
    private Colaboracion colaboracion;

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getProyecto() {
        return proyecto;
    }

    public void setProyecto(Long proyecto) {
        this.proyecto = proyecto;
    }

    public Colaboracion getColaboracion() {
        return colaboracion;
    }

    public void setColaboracion(Colaboracion colaboracion) {
        this.colaboracion = colaboracion;
    }
}
