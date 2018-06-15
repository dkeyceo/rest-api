package com.dkey.rest.repository;

import com.dkey.rest.entity.Message;
import com.dkey.rest.entity.MessageMapping;
import com.dkey.rest.entity.User;

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
public class MessageMappingRepository {
    @PersistenceContext
    private EntityManager em;
//    @Inject
//    private Logger logger;

    public List<MessageMapping> getAll(){
//        logger.info("Getting all records");
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteriaQuery = criteriaBuilder.createQuery(MessageMapping.class);
        Root<MessageMapping> e = criteriaQuery.from(MessageMapping.class);
        criteriaQuery.select(e);
        return em.createQuery(criteriaQuery).getResultList();
    }
    public MessageMapping getById(long id){
//        logger.info("Get message mapping by id: "+id);
        return em.find(MessageMapping.class,id);
    }
    public List<MessageMapping> getByFromId(User from_id){
//        logger.info("Get message mapping by user from_id: "+ from_id);
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteriaQuery = criteriaBuilder.createQuery(MessageMapping.class);
        Root<MessageMapping> e = criteriaQuery.from(MessageMapping.class);
        criteriaQuery.select(e).where(criteriaBuilder.equal(e.get("from_id"),from_id));
        return em.createQuery(criteriaQuery).getResultList();
    }
}
