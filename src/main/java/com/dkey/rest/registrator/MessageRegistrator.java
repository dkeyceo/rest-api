package com.dkey.rest.registrator;

import com.dkey.rest.entity.Message;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

@Stateless
public class MessageRegistrator {
//    @Inject
//    private Logger logger;
    @PersistenceContext
    private EntityManager em;

    public void create(Message mp) {
//        logger.info("Created message : " + mp);
        em.merge(mp);

    }

    public void update(Message mp) {
//        logger.info("Updated message mapping: " + mp);
        em.merge(mp);
    }

    public void delete(Message mp) {
//        logger.info("Deleted message mapping: " + mp);
        em.remove(mp);
    }
}