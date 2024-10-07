package org.devbank.devbankcredit.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import org.devbank.devbankcredit.config.JPAEntityManagerFactory;
import org.devbank.devbankcredit.exception.CustomDatabaseException;
import org.devbank.devbankcredit.repository.GenericRepository;

import java.util.List;
import java.util.Optional;

public class GenericRepositoryImpl <T, ID> implements GenericRepository <T, ID> {

    private final Class<T> entityType;
    private final EntityManager entityManager;

    public GenericRepositoryImpl(Class<T> entityType) {
        this.entityType = entityType;
        this.entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
    }

    private void executeInTransaction(Runnable action) {
        entityManager.getTransaction().begin();
        try {
            action.run();
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            entityManager.getTransaction().rollback();
            throw new CustomDatabaseException("Database error occurred: " + e.getMessage(), e);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
    @Override
    public Optional<T> findById(ID id) {
        T entity = entityManager.find(entityType, id);
        return Optional.ofNullable(entity);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM "+entityType.getSimpleName()+" e", entityType).getResultList();
    }

    @Override
    public T save(T entity) {
        executeInTransaction(() -> entityManager.persist(entity));
        return entity;
    }

    @Override
    public T update(T entity) {
        executeInTransaction(() -> entityManager.merge(entity));
        return entity;
    }

    @Override
    public void delete(ID id) {
        executeInTransaction(() -> {
            T entity = entityManager.find(entityType, id);
            if(entity != null) {
                entityManager.remove(entity);
            }
            else {
                throw new EntityNotFoundException("credit Request with id " + id + " not found");
            }
        });
    }
}
