package de.msg.edu.at.hibernate.persistence.daos;

import de.msg.edu.at.hibernate.persistence.entities.DemoEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

/**
 * Defines a repository in the demo application.
 */
@Stateless
public class DemoEntityDao {
    @PersistenceContext
    EntityManager em;

    public DemoEntity get(UUID id) {
       return em.find(DemoEntity.class, id);
    }

    public DemoEntity save(DemoEntity entity) {
        em.persist(entity);
        return entity;
    }

    public void delete(UUID id) {
        em.remove(id);
    }
}
