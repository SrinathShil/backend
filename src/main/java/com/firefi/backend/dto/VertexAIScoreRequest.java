package com.firefi.backend.dto;

import lombok.Data;

@Data
public class VertexAIScoreRequest {
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
    private Double assetTypeValuation;
    private String apiKey; // <-- Add this field

}