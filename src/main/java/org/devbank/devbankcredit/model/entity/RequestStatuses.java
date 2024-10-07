package org.devbank.devbankcredit.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "request_status")
public class RequestStatuses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "explination")
    private String explination;

    @ManyToOne
    @JoinColumn(name = "creditRequest_id", referencedColumnName = "id", nullable = false)
    private CreditRequest creditRequest;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private Status status;

    @NotNull
    @Column(name = "statusDate", nullable = false)
    private LocalDateTime statusDate = LocalDateTime.now();
}
