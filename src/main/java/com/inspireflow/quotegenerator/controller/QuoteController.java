package com.inspireflow.quotegenerator.controller;

import com.inspireflow.quotegenerator.model.Quote;
import com.inspireflow.quotegenerator.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend to access
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/quote")
    public ResponseEntity<Quote> getRandomQuote() {
        try {
            Quote quote = quoteService.getRandomQuote();
            return ResponseEntity.ok(quote);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("OK - Backend is running");
    }

    @GetMapping("/quotes/demo")
    public ResponseEntity<Quote> getDemoQuote() {
        // Direct endpoint for demo quotes
        Quote quote = quoteService.getDemoQuote();
        return ResponseEntity.ok(quote);
    }
    
}