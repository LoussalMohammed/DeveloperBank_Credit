package org.devbank.devbankcredit.service.serviceImpl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Validator;
import org.devbank.devbankcredit.model.entity.RequestStatuses;
import org.devbank.devbankcredit.repository.RequestStatusesRepository;
import org.devbank.devbankcredit.service.RequestStatusesService;

@ApplicationScoped
public class RequestStatusesServiceImpl extends GenericServiceImpl <RequestStatuses, Integer> implements RequestStatusesService {

    @Inject
    public RequestStatusesServiceImpl(RequestStatusesRepository requestStatusesRepository, Validator validator) {
        super(requestStatusesRepository, validator);
    }
}
