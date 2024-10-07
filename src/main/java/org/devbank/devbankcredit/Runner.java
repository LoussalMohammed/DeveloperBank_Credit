package org.devbank.devbankcredit;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import org.devbank.devbankcredit.repository.CreditRequestRepository;
import org.devbank.devbankcredit.service.CreditRequestService;


public class Runner {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            CreditRequestService creditRequestService = container.select(CreditRequestService.class).get();
            // Now you can call methods on creditRequestService
            creditRequestService.findAll();
        }
    }
}
