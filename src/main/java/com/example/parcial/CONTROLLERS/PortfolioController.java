package com.example.parcial.CONTROLLERS;

import com.example.parcial.MODELENTITY.Portfolio;
import com.example.parcial.SERVICES.INTERFACES.IPortfolioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PortfolioController {

    @Autowired
    private IPortfolioService portfolioService;

    @GetMapping("/portfolio")
    public List<Portfolio> getPortfolios() {
        return portfolioService.findAll();
    }

    @PostMapping("/portfolio")
    public ResponseEntity<?> createPortfolio(@Valid @RequestBody Portfolio portfolio) {
        Map<String, String> response = new HashMap<>();

        try {
            portfolioService.save(portfolio);
        } catch (Exception e) {
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }

        return ResponseEntity.status(201).body(portfolio);
    }

    @GetMapping("/portfolio/{id}")
    public ResponseEntity<?> getPortfolioById(@PathVariable Long id) {
        Portfolio portfolio = portfolioService.findById(id);
        Map<String, String> response = new HashMap<>();

        if (portfolio == null) {
            response.put("message", "Portfolio not found");
            return ResponseEntity.status(404).body(response);
        }

        return ResponseEntity.status(200).body(portfolio);
    }

    @PutMapping("/portfolio/{id}")
    public ResponseEntity<?> updatePortfolio(@RequestBody Portfolio updatedPortfolio, @PathVariable Long id) {
        Portfolio portfolio = portfolioService.findById(id);

        if (portfolio == null) {
            return ResponseEntity.status(404).body("Portfolio not found");
        }

        portfolio.setBiography(updatedPortfolio.getBiography());
        portfolio.setIDUser(updatedPortfolio.getIDUser());

        portfolioService.save(portfolio);
        return ResponseEntity.status(200).body(portfolio);
    }

    @DeleteMapping("/portfolio/{id}")
    public ResponseEntity<?> deletePortfolio(@PathVariable Long id) {
        try {
            portfolioService.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting portfolio");
        }
        return ResponseEntity.status(200).body("Portfolio deleted successfully");
    }
}
