package org.devbank.devbankcredit.repository.repositoryImpl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.Setter;
import org.devbank.devbankcredit.model.entity.Status;
import org.devbank.devbankcredit.repository.StatusRepository;

@Getter
@Setter
@ApplicationScoped
public class StatusRepositoryImpl extends GenericRepositoryImpl <Status, Integer> implements StatusRepository {
    public StatusRepositoryImpl() {
        super(Status.class);
    }
}
