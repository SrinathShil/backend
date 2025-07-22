package com.firefi.backend.controller;


import com.firefi.backend.dto.LoanApplicationRequest;
import com.firefi.backend.model.LoanApplication;
import com.firefi.backend.model.User;
import com.firefi.backend.repository.LoanApplicationRepository;
import com.firefi.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/submit/{username}")
    public String submitLoanApplication(@PathVariable String username,
                                        @RequestBody LoanApplicationRequest request) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return "User not found";
        }
        LoanApplication app = new LoanApplication();
        app.setUser(user);
        app.setLoanType(request.getLoanType());
        app.setLoanAmountRequested(request.getLoanAmountRequested());
        app.setEmploymentStatus(request.getEmploymentStatus());
        app.setMonthlyIncome(request.getMonthlyIncome());
        app.setExistingEMIsMonthly(request.getExistingEMIsMonthly());
        app.setPropertyOwnershipStatus(request.getPropertyOwnershipStatus());
        app.setResidentialAddress(request.getResidentialAddress());
        app.setApplicantAge(request.getApplicantAge());
        app.setGender(request.getGender());
        app.setNumberOfDependents(request.getNumberOfDependents());
        app.setLoanStatus(request.getLoanStatus());
        app.setAssetTypeValuation(request.getAssetTypeValuation());
        app.setLoanLimit(request.getLoanLimit());
        app.setDebtToIncomeRatio(request.getDebtToIncomeRatio());
        app.setInterestRateOffered(request.getInterestRateOffered());
        app.setApplicationId(request.getApplicationId());
        app.setCustomerId(request.getCustomerId());
        app.setApplicationDate(request.getApplicationDate());
        loanApplicationRepository.save(app);
        return "Loan application submitted";
    }

    @PutMapping("/update/{username}/{loanId}")
    public LoanApplication updateLoan(
            @PathVariable String username,
            @PathVariable Long loanId,
            @RequestBody LoanUpdateRequest request
    ) {
        LoanApplication loanApplication = loanApplicationRepository
                .findByIdAndUserUsername(loanId, username)
                .orElseThrow(() -> new RuntimeException("Loan Application not found for user"));

        loanApplication.setLoanStatus(request.getLoanStatus());
        loanApplication.setLoanLimit(request.getLoanLimit());

        return loanApplicationRepository.save(loanApplication);
    }

    @GetMapping("/user/{username}")
    public List<LoanApplication> getLoansByUsername(@PathVariable String username) {
        return loanApplicationRepository.findByUserUsername(username);
    }

    // Get all loans for a user by userId
    @GetMapping("/user/id/{userId}")
    public List<LoanApplication> getLoansByUserId(@PathVariable Long userId) {
        return loanApplicationRepository.findByUserId(userId);
    }

}