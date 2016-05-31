package es.rcentell.tasking.core.services.impl;

import es.rcentell.tasking.core.models.entities.Colaboracion;
import es.rcentell.tasking.core.models.entities.Proyecto;
import es.rcentell.tasking.core.models.entities.Usuario;
import es.rcentell.tasking.core.repositories.*;
import es.rcentell.tasking.core.services.ColaboracionService;
import es.rcentell.tasking.core.services.exceptions.AlreadyExistsException.ColaboracionAlreadyExistsException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.ColaboracionNotFoundException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.ProyectoNotFoundException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.UsuarioNotFoundException;
import es.rcentell.tasking.core.services.utils.ListaDistribucionList;
import es.rcentell.tasking.core.services.utils.SubtareaList;
import es.rcentell.tasking.core.services.utils.TareaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Service
@Transactional
public class ColaboracionServiceImpl implements ColaboracionService{

    @Autowired
    private ColaboracionRepository colaboracionRepository;
    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private SubtareaRepository subtareaRepository;
    @Autowired
    private ProyectoRepository proyectoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ListaDistribucionRepository listaDistribucionRepository;


    @Override
    public Colaboracion createColaboracion(Long proyectoId, Long usuarioId, Colaboracion data) {
        Proyecto proyecto= proyectoRepository.findProyecto(proyectoId);
        Usuario usuario= usuarioRepository.findUsuario(usuarioId);
        if(proyecto == null)
        {
            throw new ProyectoNotFoundException();
        }
        if(usuario == null)
        {
            throw new UsuarioNotFoundException();
        }
        Colaboracion colaboracion = colaboracionRepository.createColaboracion(data);
        colaboracion.setProyecto(proyecto);
        colaboracion.setUsuario(usuario);
        return colaboracion;
    }

    @Override
    public ListaDistribucionList findAllListasDistribucion(Long colaboracionId) {
        Colaboracion colaboracion= colaboracionRepository.findColaboracion(colaboracionId);
        if(colaboracion == null)
        {
            throw new ColaboracionNotFoundException();
        }
        return new ListaDistribucionList(colaboracionId, listaDistribucionRepository.findByColaboracionId(colaboracionId));
    }

    @Override
    public Colaboracion findColaboracion(Long id) {
        Colaboracion colaboracion = colaboracionRepository.findColaboracion(id);
        if(colaboracion==null)
        {
            throw new ColaboracionNotFoundException();
        }
        else{
            return colaboracion;
        }
    }
    @Override
    public Colaboracion deleteColaboracion(Long id) {
        return colaboracionRepository.deleteColaboracion(id);
    }

    @Override
    public Colaboracion updateColaboracion(Long id, Colaboracion data) {
        return colaboracionRepository.updateColaboracion(id, data);
    }

    @Override
    public SubtareaList findAllSubtareasAsiganadas(Long id) {
        Colaboracion colaboracion = colaboracionRepository.findColaboracion(id);
        if(colaboracion == null)
        {
            throw new ColaboracionNotFoundException();
        }
        return new SubtareaList(null,id,null, subtareaRepository.findByAsignacionId(id));
    }

    @Override
    public SubtareaList findAllSubtareasCreadas(Long id) {
        Colaboracion colaboracion = colaboracionRepository.findColaboracion(id);
        if(colaboracion == null)
        {
            throw new ColaboracionNotFoundException();
        }
        return new SubtareaList(null,id, null,subtareaRepository.findByCreadorId(id));
    }

    @Override
    public TareaList findAllTareasAsiganadas(Long id) {
        Colaboracion colaboracion = colaboracionRepository.findColaboracion(id);
        if(colaboracion == null)
        {
            throw new ColaboracionNotFoundException();
        }
        return new TareaList(null,id,null, tareaRepository.findByAsignacionId(id));
    }

    @Override
    public TareaList findAllTareasCreadas(Long id) {
        Colaboracion colaboracion = colaboracionRepository.findColaboracion(id);
        if(colaboracion == null)
        {
            throw new ColaboracionNotFoundException();
        }
        return new TareaList(null,id,null, tareaRepository.findByCreadorId(id));
    }
}
