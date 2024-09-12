package com.example.parcial.CONTROLLERS;

import com.example.parcial.DTO.PortfolioDTO;
import com.example.parcial.MODELENTITY.Portfolio;
import com.example.parcial.SERVICES.INTERFACES.IPortfolioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class PortfolioController {

    @Autowired
    private IPortfolioService portfolioService;

    @GetMapping("/portfolio")
    public ResponseEntity<?> getAllPortfolios() {
        System.out.println("getAllPortfolios");

        try {
            List<Portfolio> all = portfolioService.findAll();
            return ResponseEntity.status(200).body(all);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/portfolio/{id}")
    public ResponseEntity<?> getPortfolioById(@PathVariable Long id) {
        System.out.println("getPortfolioById");

        Portfolio portfolio = portfolioService.findById(id);

        if (portfolio == null) {
            return ResponseEntity.status(404).body("Portfolio not found");
        }

        return ResponseEntity.status(200).body(portfolio);
    }

    @DeleteMapping("/portfolio/{id}")
    public ResponseEntity<?> deletePortfolio(@PathVariable Long id) {
        System.out.println("deletePortfolio");

        try {
            portfolioService.deleteById(id);
            return ResponseEntity.status(204).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/portfolio")
    public ResponseEntity<?> createPortfolio(@Valid @RequestBody PortfolioDTO portfolioDTO) {
        System.out.println("createPortfolio");

        try {
            Portfolio portfolio = portfolioService.createPortfolio(portfolioDTO);
            return ResponseEntity.status(201).body(portfolio);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(400).body(error.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/portfolio/{id}")
    public ResponseEntity<?> updatePortfolio(@RequestBody PortfolioDTO portfolioDTO, @PathVariable Long id) {
        System.out.println("updatePortfolio");

        try {
            Portfolio updatedPortfolio = portfolioService.updatePortfolio(portfolioDTO, id);
            return ResponseEntity.status(200).body(updatedPortfolio);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(400).body(error.getMessage());
        } catch (Exception error) {
            return ResponseEntity.status(500).body(error.getMessage());
        }
    }
}
