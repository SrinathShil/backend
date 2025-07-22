package com.firefi.backend.repository;


import com.firefi.backend.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
    Optional<LoanApplication> findByIdAndUserUsername(Long id, String username);
    List<LoanApplication> findByUserUsername(String username);
    List<LoanApplication> findByUserId(Long userId);


}
