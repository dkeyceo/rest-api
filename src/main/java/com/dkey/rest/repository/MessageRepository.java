package com.dkey.rest.repository;

import com.dkey.rest.entity.Message;
import com.dkey.rest.entity.MessageMapping;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class MessageRepository {
    @PersistenceContext
    private EntityManager em;
//    @Inject
//    private Logger logger;

    public List<Message> getAll(){
//        logger.info("Getting all message records");
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Message> criteriaQuery = criteriaBuilder.createQuery(Message.class);
        Root<Message> e = criteriaQuery.from(Message.class);
        criteriaQuery.select(e);
        return em.createQuery(criteriaQuery).getResultList();
    }
    public Message getById(long id){
//        logger.info("Get message mapping by id: "+id);
        return em.find(Message.class,id);
    }
}
