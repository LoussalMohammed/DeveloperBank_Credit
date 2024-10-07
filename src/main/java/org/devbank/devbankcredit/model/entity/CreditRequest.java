package org.devbank.devbankcredit.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.devbank.devbankcredit.model.enums.CreditRequestStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "credit_requests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreditRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "project")
    private String project;

    @NotNull
    @Column(name = "job")
    private String job;

    @NotNull
    @Min(0)
    @Column(name = "amount", columnDefinition = "Decimal(20, 8)")
    private BigDecimal amount;

    @NotNull
    @Min(1)
    @Column(name = "duration", columnDefinition = "int")
    private long duration;

    @NotNull
    @Column(name = "monthlyPaymentsAmount")
    private double monthlyPaymentsAmount;

    @NotNull
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Size(min = 10, max = 13)
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "civility")
    private String civility;

    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Size(min = 5)
    @Column(name = "cin")
    private String cin;

    @NotNull
    @Column(name = "bornDate")
    private LocalDate bornDate;

    @NotNull
    @Column(name = "startDate")
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "totalRevenue", columnDefinition = "DECIMAL(20, 8)")
    private BigDecimal totalRevenue;

    @NotNull
    @Column(name = "hasOngoingCredits", nullable = false)
    private boolean hasOngoingCredits = false;

    @NotNull
    @Column(name = "acceptConditions", nullable = false)
    private boolean acceptConditions = true;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CreditRequestStatus status = CreditRequestStatus.PENDING;

    @OneToMany(mappedBy = "credit_requests", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RequestStatuses> requestStatuses = new ArrayList<>();
}
