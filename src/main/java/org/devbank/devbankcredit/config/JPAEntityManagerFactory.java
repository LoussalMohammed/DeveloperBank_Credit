package org.devbank.devbankcredit.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.Produces;

@ApplicationScoped
public class JPAEntityManagerFactory {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        try  {
            ENTITY_MANAGER_FACTORY =  Persistence.createEntityManagerFactory("DevBankCreditPU");
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Entity Manger Factory Enitialization Failed:"+ e.getMessage());
        }
    }

    @Produces
    public static EntityManagerFactory getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY;
    }

}
