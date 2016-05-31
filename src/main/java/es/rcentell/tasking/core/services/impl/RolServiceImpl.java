package es.rcentell.tasking.core.services.impl;

import es.rcentell.tasking.core.models.entities.Rol;
import es.rcentell.tasking.core.repositories.RolRepository;
import es.rcentell.tasking.core.services.RolService;
import es.rcentell.tasking.core.services.exceptions.AlreadyExistsException.RolAlreadyExistsException;
import es.rcentell.tasking.core.services.exceptions.NotFoundException.RolNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Rcentell on 30/05/2016.
 */
@Service
@Transactional
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository rolRepository;


    @Override
    public Rol findRol(Long id) {
        Rol rol = rolRepository.findRol(id);
        if(rol==null)
        {
            throw new RolNotFoundException();
        }
        else{
            return rol;
        }
    }
    @Override
    public Rol deleteRol(Long id) {
        return rolRepository.deleteRol(id);
    }

    @Override
    public Rol updateRol(Long id, Rol data) {
        return rolRepository.updateRol(id, data);
    }


}
