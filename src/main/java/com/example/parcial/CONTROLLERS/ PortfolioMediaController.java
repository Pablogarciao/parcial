package com.example.parcial.CONTROLLERS;

import com.example.parcial.MODELENTITY.PortfolioMedia;
import com.example.parcial.SERVICES.INTERFACES.IPortfolioMediaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PortfolioMediaController {

    @Autowired
    private IPortfolioMediaService portfolioMediaService;

    @GetMapping("/portfolioMedia")
    public List<PortfolioMedia> getPortfolioMedia() {
        return portfolioMediaService.findAll();
    }

    @PostMapping("/portfolioMedia")
    public ResponseEntity<?> createPortfolioMedia(@Valid @RequestBody PortfolioMedia portfolioMedia) {
        Map<String, String> response = new HashMap<>();

        try {
            portfolioMediaService.save(portfolioMedia);
        } catch (Exception e) {
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }

        return ResponseEntity.status(201).body(portfolioMedia);
    }

    @GetMapping("/portfolioMedia/{id}")
    public ResponseEntity<?> getPortfolioMediaById(@PathVariable Long id) {
        PortfolioMedia portfolioMedia = portfolioMediaService.findById(id);
        Map<String, String> response = new HashMap<>();

        if (portfolioMedia == null) {
            response.put("message", "PortfolioMedia not found");
            return ResponseEntity.status(404).body(response);
        }

        return ResponseEntity.status(200).body(portfolioMedia);
    }

    @PutMapping("/portfolioMedia/{id}")
    public ResponseEntity<?> updatePortfolioMedia(@RequestBody PortfolioMedia updatedPortfolioMedia, @PathVariable Long id) {
        PortfolioMedia portfolioMedia = portfolioMediaService.findById(id);

        if (portfolioMedia == null) {
            return ResponseEntity.status(404).body("PortfolioMedia not found");
        }

        portfolioMedia.setMedia(updatedPortfolioMedia.getMedia());
        portfolioMedia.setIDPortfolio(updatedPortfolioMedia.getIDPortfolio());

        portfolioMediaService.save(portfolioMedia);
        return ResponseEntity.status(200).body(portfolioMedia);
    }

    @DeleteMapping("/portfolioMedia/{id}")
    public ResponseEntity<?> deletePortfolioMedia(@PathVariable Long id) {
        try {
            portfolioMediaService.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting portfolioMedia");
        }
        return ResponseEntity.status(200).body("PortfolioMedia deleted successfully");
    }
}
