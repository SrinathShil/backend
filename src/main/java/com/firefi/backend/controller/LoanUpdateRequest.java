package com.firefi.backend.controller;

import lombok.Data;

@Data
public class LoanUpdateRequest {
    private String loanStatus;
    private Double loanLimit;
}