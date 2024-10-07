package org.devbank.devbankcredit.repository.repositoryImpl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.Setter;
import org.devbank.devbankcredit.model.entity.CreditRequest;
import org.devbank.devbankcredit.repository.CreditRequestRepository;

@Getter
@Setter
@ApplicationScoped
public class CreditRequestRepositoryImpl extends GenericRepositoryImpl <CreditRequest, Integer> implements CreditRequestRepository {

    public CreditRequestRepositoryImpl() {
        super(CreditRequest.class);
    }
}
