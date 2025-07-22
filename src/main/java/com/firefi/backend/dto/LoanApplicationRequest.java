package com.firefi.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LoanApplicationRequest {
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
    private Date applicationDate;
}