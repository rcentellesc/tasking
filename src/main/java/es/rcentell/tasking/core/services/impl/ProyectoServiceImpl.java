package es.rcentell.tasking.core.services.impl;

import es.rcentell.tasking.core.models.entities.ListaDistribucion;
import es.rcentell.tasking.core.models.entities.Proyecto;
import es.rcentell.tasking.core.models.entities.Rol;
import es.rcentell.tasking.core.models.entities.Tarea;
import es.rcentell.tasking.core.repositories.*;
import es.rcentell.tasking.core.services.ProyectoService;
import es.rcentell.tasking.core.services.exceptions.AlreadyExistsException.ProyectoAlreadyExistsException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.ProyectoNotFoundException;
import es.rcentell.tasking.core.services.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Service
@Transactional
public class ProyectoServiceImpl implements ProyectoService{

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private ColaboracionRepository colaboracionRepository;

    @Autowired
    private ListaDistribucionRepository listaDistribucionRepository;

    @Override
    public Proyecto findProyecto(Long id) {
        Proyecto proyecto = proyectoRepository.findProyecto(id);
        if(proyecto==null)
        {
            throw new ProyectoNotFoundException();
        }
        else{
            return proyecto;
        }
    }

    @Override
    public Proyecto createProyecto(Proyecto data) {

        Proyecto proyecto = proyectoRepository.createProyecto(data);
        return proyecto;
    }
    @Override
    public Proyecto deleteProyecto(Long id) {
        return proyectoRepository.deleteProyecto(id);
    }

    @Override
    public Proyecto updateProyecto(Long id, Proyecto data) {
        return proyectoRepository.updateProyecto(id, data);
    }


    @Override
    public ProyectoList findAllProyectos() {
        return new ProyectoList(null,proyectoRepository.findAllProyectos());
    }

    @Override
    public Tarea createTarea(Long proyectoId, Tarea data) {
        Proyecto proyecto= proyectoRepository.findProyecto(proyectoId);
        if(proyecto == null)
        {
            throw new ProyectoNotFoundException();
        }
        Tarea tarea = tareaRepository.createTarea(data);
        tarea.setProyecto(proyecto);
        return tarea;
    }

    @Override
    public Rol createRol(Long proyectoId, Rol data) {
        Proyecto proyecto= proyectoRepository.findProyecto(proyectoId);
        if(proyecto == null)
        {
            throw new ProyectoNotFoundException();
        }
        Rol rol = rolRepository.createRol(data);
        rol.setProyecto(proyecto);
        return rol;
    }

    @Override
    public ListaDistribucion createListaDistribucion(Long proyectoId, ListaDistribucion data) {
        Proyecto proyecto= proyectoRepository.findProyecto(proyectoId);
        if(proyecto == null)
        {
            throw new ProyectoNotFoundException();
        }
        ListaDistribucion listaDistribucion = listaDistribucionRepository.createListaDistribucion(data);
        listaDistribucion.setProyecto(proyecto);
        return listaDistribucion;
    }

    @Override
    public TareaList findAllTareas(Long proyectoId) {
        Proyecto proyecto= proyectoRepository.findProyecto(proyectoId);
        if(proyecto == null)
        {
            throw new ProyectoNotFoundException();
        }
        return new TareaList(proyectoId,null,null, tareaRepository.findByProyectoId(proyectoId));
    }
    @Override
    public TareaList findAllTareasDesasignadas(Long proyectoId) {
        Proyecto proyecto= proyectoRepository.findProyecto(proyectoId);
        if(proyecto == null)
        {
            throw new ProyectoNotFoundException();
        }
        return new TareaList(proyectoId, null,null,tareaRepository.findByProyectoIdDesasignadas(proyectoId));
    }

    @Override
    public ListaDistribucionList findAllListasDistribucion(Long proyectoId) {
        Proyecto proyecto= proyectoRepository.findProyecto(proyectoId);
        if(proyecto == null)
        {
            throw new ProyectoNotFoundException();
        }
        return new ListaDistribucionList(proyectoId, listaDistribucionRepository.findByProyectoId(proyectoId));
    }

    @Override
    public RolList findAllRoles(Long proyectoId) {
        Proyecto proyecto= proyectoRepository.findProyecto(proyectoId);
        if(proyecto == null)
        {
            throw new ProyectoNotFoundException();
        }
        return new RolList(proyectoId, rolRepository.findByProyectoId(proyectoId));
    }

    @Override
    public ColaboracionList findAllColaboraciones(Long proyectoId) {
        Proyecto proyecto= proyectoRepository.findProyecto(proyectoId);
        if(proyecto == null)
        {
            throw new ProyectoNotFoundException();
        }
        return new ColaboracionList(null,proyectoId,null, colaboracionRepository.findByProyectoId(proyectoId));
    }


}
