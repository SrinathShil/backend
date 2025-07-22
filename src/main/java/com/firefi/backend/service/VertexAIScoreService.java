package com.firefi.backend.service;


import com.firefi.backend.dto.VertexAIScoreRequest;
import com.firefi.backend.dto.VertexAIScoreResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class VertexAIScoreService {

    @Value("${vertexai.endpoint.url}")
    private String endpointUrl;

    @Value("${vertexai.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public VertexAIScoreResponse getScore(VertexAIScoreRequest request) {
        // Build the payload as expected by Vertex AI endpoint
        Map<String, Object> payload = new HashMap<>();
        payload.put("Loan_Type", request.getLoanType());
        payload.put("Loan_Amount_Requested", request.getLoanAmountRequested());
        payload.put("Employment_Status", request.getEmploymentStatus());
        payload.put("Monthly_Income", request.getMonthlyIncome());
        payload.put("Existing_EMIs_Monthly", request.getExistingEMIsMonthly());
        payload.put("Property_Ownership_Status", request.getPropertyOwnershipStatus());
        payload.put("Residential_Address", request.getResidentialAddress());
        payload.put("Applicant_Age", request.getApplicantAge());
        payload.put("Gender", request.getGender());
        payload.put("Number_of_Dependents", request.getNumberOfDependents());
        payload.put("Asset_Type_Valuation", request.getAssetTypeValuation());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // Use apiKey from request (if present)
        String apiKeys = request.getApiKey();
        if (apiKeys != null && !apiKeys.isEmpty()) {
            headers.setBearerAuth(apiKeys);
        }else {
            headers.setBearerAuth(apiKey); // OR use set("Authorization", "Bearer ...") for OAuth2 tokens
        }
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);

        ResponseEntity<Map> response = restTemplate.exchange(endpointUrl, HttpMethod.POST, entity, Map.class);

        VertexAIScoreResponse scoreResponse = new VertexAIScoreResponse();
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            // Assume the response contains a field "score"
            Object scoreObj = response.getBody().get("score");
            if (scoreObj != null) {
                scoreResponse.setScore(Double.valueOf(scoreObj.toString()));
            }
            scoreResponse.setMessage("Success");
        } else {
            scoreResponse.setMessage("Failed to fetch score from Vertex AI");
        }
        return scoreResponse;
    }
}
