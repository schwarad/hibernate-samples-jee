package de.msg.edu.at.hibernate.business.services;

import de.msg.edu.at.hibernate.persistence.daos.DemoEntityDao;
import de.msg.edu.at.hibernate.persistence.entities.DemoEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.UUID;

/**
 * Defines the business layer of the demo application.
 */
@Stateless
public class DemoBusiness {

    @EJB
    private DemoEntityDao demoEntityDao;

    public DemoEntity get(UUID id) {
        return demoEntityDao.get(id);
    }

    public DemoEntity save(DemoEntity demoEntity) {
        return demoEntityDao.save(demoEntity);
    }

    public DemoEntity update(DemoEntity demoEntity) {
        return  demoEntityDao.update(demoEntity);
    }

    public boolean delete(UUID id) {
        return demoEntityDao.delete(id);
    }
}
