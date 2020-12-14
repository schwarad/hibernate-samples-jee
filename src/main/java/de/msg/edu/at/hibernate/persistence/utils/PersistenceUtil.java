package de.msg.edu.at.hibernate.persistence.utils;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.*;

@ApplicationScoped
public class PersistenceUtil {

    @PersistenceUnit(name = "demo")
    private EntityManagerFactory emf;

    @Produces
    @Default
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
