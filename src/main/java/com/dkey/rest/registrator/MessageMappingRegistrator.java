package com.dkey.rest.registrator;

import com.dkey.rest.entity.MessageMapping;

import javax.ejb.Stateless;
//import javax.inject.Inject;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

@Stateless
public class MessageMappingRegistrator {
//    @Inject
//    private Logger logger;
    @PersistenceContext
    private EntityManager em;

    public void create(MessageMapping mp){
//        logger.info("Created message mapping: "+ mp);
        em.merge(mp);

    }
    public void update(MessageMapping mp){
//        logger.info("Updated message mapping: "+mp);
        em.merge(mp);
    }
    public void delete(MessageMapping mp){
//        logger.info("Deleted message mapping: "+mp);
        em.remove(mp);
    }

}
