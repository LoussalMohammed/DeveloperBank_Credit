package org.devbank.devbankcredit.producer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.ws.rs.Produces;
import org.devbank.devbankcredit.config.JPAEntityManagerFactory;

@ApplicationScoped
public class EntityManagerProducer {

    @Produces
    public EntityManager CreateEntityManager() {
        return JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
    }
}
