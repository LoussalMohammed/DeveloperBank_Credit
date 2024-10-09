package org.devbank.devbankcredit.service.serviceImpl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Validator;
import org.devbank.devbankcredit.model.entity.CreditRequest;
import org.devbank.devbankcredit.repository.CreditRequestRepository;
import org.devbank.devbankcredit.service.CreditRequestService;

import jakarta.inject.Inject;

@ApplicationScoped
public class CreditServiceImpl extends GenericServiceImpl <CreditRequest, Integer> implements CreditRequestService {

    @Inject
    public CreditServiceImpl(CreditRequestRepository creditRequestRepository, Validator validator) {
        super(creditRequestRepository, validator);
    }


}
