package org.devbank.devbankcredit.service.serviceImpl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.devbank.devbankcredit.exception.CustomValidationException;
import org.devbank.devbankcredit.repository.GenericRepository;
import org.devbank.devbankcredit.service.GenericService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public abstract class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    protected GenericRepository<T, ID> repository;
    protected Validator validator;

    public GenericServiceImpl(GenericRepository<T, ID> repository, Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        System.out.println("here");
        return repository.findAll();
    }

    @Override
    public T save(T entity) {
        validate(entity);
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        validate(entity);
        return repository.update(entity);
    }

    @Override
    public void delete(ID id) {
        repository.delete(id);
    }

    private void validate(T entity) {
        Set<ConstraintViolation<T>> violations = validator.validate(entity);
        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Validation failed:\n");
            violations.forEach(violation -> errorMessage.append(violation.getMessage()).append(";\n"));
            throw new CustomValidationException(errorMessage.toString());
        }
    }
}


