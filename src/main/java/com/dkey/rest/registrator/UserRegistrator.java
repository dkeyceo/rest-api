package com.dkey.rest.registrator;

import com.dkey.rest.entity.Message;
import com.dkey.rest.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

@Stateless
public class UserRegistrator {
//    @Inject
//    private Logger logger;
    @PersistenceContext
    private EntityManager em;

    public void create(User user) {
//        logger.info("Created user : " + user);
        em.merge(user);

    }

    public void update(User user) {
//        logger.info("Updated user: " + user);
        em.merge(user);
    }

    public void delete(User user) {
//        logger.info("Deleted user: " + user);
        em.remove(user);
    }
}
