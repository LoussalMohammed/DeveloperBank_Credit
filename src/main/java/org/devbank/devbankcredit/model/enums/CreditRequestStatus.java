package org.devbank.devbankcredit.model.enums;

/**
 * Enum representing the possible statuses of a credit request.
 */
public enum CreditRequestStatus {

    /**
     * First State The Credit Request In Process
     */
    PENDING,
    /**
     * Credit Request Rejected
     */
    REJECTED,
    /**
     * Credit Request Approved
     */
    APPROVED,
    /**
     * Credit Request Canceled
     */
    CANCELED;


    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

}
