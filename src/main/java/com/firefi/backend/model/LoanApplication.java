package com.firefi.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "loan_application")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanType;
    private Double loanAmountRequested;
    private String employmentStatus;
    private Double monthlyIncome;
    private Double existingEMIsMonthly;
    private String propertyOwnershipStatus;
    private String residentialAddress;
    private Integer applicantAge;
    private String gender;
    private Integer numberOfDependents;
    private String loanStatus;
    private Double assetTypeValuation;
    private Double loanLimit;
    private Double debtToIncomeRatio;
    private Double interestRateOffered;
    private String applicationId;
    private String customerId;
    @Temporal(TemporalType.DATE)
    private Date applicationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
