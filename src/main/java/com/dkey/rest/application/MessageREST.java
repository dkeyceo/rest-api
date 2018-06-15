package com.dkey.rest.application;

import com.dkey.rest.entity.Message;
import com.dkey.rest.entity.MessageMapping;
import com.dkey.rest.registrator.MessageRegistrator;
import com.dkey.rest.repository.MessageRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/message")
public class MessageREST {
    @Inject
    private MessageRepository messageRepository;
    @Inject
    private MessageRegistrator messageRegistrator;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getById(@PathParam("id") long id){
        return messageRepository.getById(id);
    }


}
