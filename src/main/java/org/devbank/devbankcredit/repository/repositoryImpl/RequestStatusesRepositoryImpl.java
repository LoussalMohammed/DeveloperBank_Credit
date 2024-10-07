package org.devbank.devbankcredit.repository.repositoryImpl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.Setter;
import org.devbank.devbankcredit.model.entity.RequestStatuses;
import org.devbank.devbankcredit.repository.RequestStatusesRepository;
import org.devbank.devbankcredit.service.RequestStatusesService;

@Getter
@Setter
@ApplicationScoped
public class RequestStatusesRepositoryImpl extends GenericRepositoryImpl <RequestStatuses, Integer> implements RequestStatusesRepository {
    public RequestStatusesRepositoryImpl() {
        super(RequestStatuses.class);
    }
}
