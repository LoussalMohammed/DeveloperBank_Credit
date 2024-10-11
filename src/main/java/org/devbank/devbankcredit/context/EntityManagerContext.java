package org.devbank.devbankcredit.context;

import jakarta.persistence.EntityManager;

public class EntityManagerContext {
    private static final ThreadLocal<EntityManager> entityMangerThreadLocal = new ThreadLocal<>();

    public static void bind(EntityManager entityManager) {
        entityMangerThreadLocal.set(entityManager);
    }

    public static EntityManager get() {
        return entityMangerThreadLocal.get();
    }

    public static void remove() {
        entityMangerThreadLocal.remove();
    }
}
