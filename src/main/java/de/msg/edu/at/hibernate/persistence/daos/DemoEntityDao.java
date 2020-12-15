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

    public DemoEntity update(DemoEntity entity) {
        return exists(entity.getId()) ? em.merge(entity) : null;
    }

    private boolean exists(UUID id) {
        return em.find(DemoEntity.class, id) != null;
    }

    public boolean delete(UUID id) {
        DemoEntity demoEntity = em.find(DemoEntity.class, id);
        if (demoEntity != null) {
            em.remove(demoEntity);
            return true;
        }
        return false;
    }
}
