package org.devbank.devbankcredit.service.serviceImpl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Validator;
import org.devbank.devbankcredit.model.entity.Status;
import org.devbank.devbankcredit.repository.StatusRepository;
import org.devbank.devbankcredit.service.StatusService;

@ApplicationScoped
public class StatusServiceImpl extends GenericServiceImpl <Status, Integer> implements StatusService {

    @Inject
    public StatusServiceImpl(StatusRepository statusRepository, Validator validator) {
        super(statusRepository, validator);
    }
}
