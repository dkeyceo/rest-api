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
public class UserRepository {
    @PersistenceContext
    private EntityManager em;
//    @Inject
//    private Logger logger;

    public User getById(long id){
//        logger.info("Get user by id: "+id);
        return em.find(User.class,id);
    }
    public List<User> getAll(){
//        logger.info("Getting all users");
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> e = criteriaQuery.from(User.class);
        criteriaQuery.select(e);
        return em.createQuery(criteriaQuery).getResultList();
    }
    public List<User> getByNickName(String nickName){
//        logger.info("Get user by nickName : "+ nickName);
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> e = criteriaQuery.from(User.class);
        criteriaQuery.select(e).where(criteriaBuilder.equal(e.get("nickName"),nickName));
        return em.createQuery(criteriaQuery).getResultList();
    }
}
