package com.firefi.backend.controller;

import com.firefi.backend.dto.VertexAIScoreRequest;
import com.firefi.backend.dto.VertexAIScoreResponse;
import com.firefi.backend.service.VertexAIScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vertexai")
public class VertexAIController {

    @Autowired
    private VertexAIScoreService vertexAIScoreService;

    @PostMapping("/score")
    public VertexAIScoreResponse getScore(@RequestBody VertexAIScoreRequest request) {
        return vertexAIScoreService.getScore(request);
    }
}
