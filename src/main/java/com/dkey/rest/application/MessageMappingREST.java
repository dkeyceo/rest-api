package com.dkey.rest.application;

import com.dkey.rest.entity.MessageMapping;
import com.dkey.rest.registrator.MessageMappingRegistrator;
import com.dkey.rest.repository.MessageMappingRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/mes_mp")
public class MessageMappingREST {
    @Inject
    private MessageMappingRegistrator messageMappingRegistrator;
    @Inject
    private MessageMappingRepository messageMappingRepository;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageMapping> getAll(){
//        List<MessageMapping> resuList = messageMappingRepository.getAll();
        return messageMappingRepository.getAll();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageMapping getById(@PathParam("id") long id){
        return messageMappingRepository.getById(id);
    }
}
