package com.dkey.rest.application;

import com.dkey.rest.entity.Message;
import com.dkey.rest.entity.User;
import com.dkey.rest.registrator.UserRegistrator;
import com.dkey.rest.repository.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
public class UserREST {
    @Inject
    private UserRegistrator userRegistrator;
    @Inject
    private UserRepository userRepository;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll(){
        return userRepository.getAll();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getById(@PathParam("id") long id){
        return userRepository.getById(id);
    }
}
