package org.devbank.devbankcredit.web.filters;

import jakarta.persistence.EntityManager;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.devbank.devbankcredit.config.JPAEntityManagerFactory;
import org.devbank.devbankcredit.context.EntityManagerContext;
import org.devbank.devbankcredit.exception.CustomDatabaseException;

import java.io.IOException;
import java.util.logging.Logger;

@WebFilter("/*")
public class EntityManagerHandler implements Filter {
    private static final Logger LOGGER = Logger.getLogger(EntityManagerHandler.class.getName());
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

        EntityManager entityManager = null;

        try {

            entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            EntityManagerContext.bind(entityManager);

            System.out.println("Entity Manager Initialized, Proposition "+ (entityManager != null));

            if(entityManager != null && !entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
                LOGGER.info("entity manager transaction started");
                System.out.println("entity manager transaction started");
            }
            filterChain.doFilter(request, response);
            if( entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().commit();
                System.out.println("entity manager transaction commited");
            }
        } catch(Exception e) {
            if(entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                System.out.println("entity manager transaction rollback");
                throw new CustomDatabaseException("Database error occurred: " + e.getMessage(), e);
            }
        } finally {
            if(entityManager != null)
                entityManager.close();
            System.out.println("entity manager closed");
        }
    }


}
