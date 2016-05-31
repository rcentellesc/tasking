package es.rcentell.tasking.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class RolListResource extends ResourceSupport {

    private List<RolResource> roles;

    public List<RolResource> getRoles() {
        return roles;
    }

    public void setRoles(List<RolResource> roles) {
        this.roles = roles;
    }
}
