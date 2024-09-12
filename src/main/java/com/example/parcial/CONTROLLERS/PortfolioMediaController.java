package com.example.parcial.CONTROLLERS;

import com.example.parcial.DTO.PortfolioMediaDTO;
import com.example.parcial.MODELENTITY.PortfolioMedia;
import com.example.parcial.SERVICES.INTERFACES.IPortfolioMediaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class PortfolioMediaController {

    @Autowired
    private IPortfolioMediaService portfolioMediaService;

    @GetMapping("/portfoliomedia")
    public ResponseEntity<?> getAllPortfolioMedia() {
        System.out.println("getAllPortfolioMedia");

        try {
            List<PortfolioMedia> all = portfolioMediaService.findAll();
            return ResponseEntity.status(200).body(all);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/portfoliomedia/{id}")
    public ResponseEntity<?> getPortfolioMediaById(@PathVariable Long id) {
        System.out.println("getPortfolioMediaById");

        PortfolioMedia portfolioMedia = portfolioMediaService.findById(id);

        if (portfolioMedia == null) {
            return ResponseEntity.status(404).body("PortfolioMedia not found");
        }

        return ResponseEntity.status(200).body(portfolioMedia);
    }

    @DeleteMapping("/portfoliomedia/{id}")
    public ResponseEntity<?> deletePortfolioMedia(@PathVariable Long id) {
        System.out.println("deletePortfolioMedia");

        try {
            portfolioMediaService.deleteById(id);
            return ResponseEntity.status(204).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/portfoliomedia")
    public ResponseEntity<?> createPortfolioMedia(@Valid @RequestBody PortfolioMediaDTO portfolioMediaDTO) {
        System.out.println("createPortfolioMedia");

        try {
            PortfolioMedia portfolioMedia = portfolioMediaService.createPortfolioMedia(portfolioMediaDTO);
            return ResponseEntity.status(201).body(portfolioMedia);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(400).body(error.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/portfoliomedia/{id}")
    public ResponseEntity<?> updatePortfolioMedia(@RequestBody PortfolioMediaDTO portfolioMediaDTO, @PathVariable Long id) {
        System.out.println("updatePortfolioMedia");

        try {
            PortfolioMedia updatedMedia = portfolioMediaService.updatePortfolioMedia(portfolioMediaDTO, id);
            return ResponseEntity.status(200).body(updatedMedia);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(400).body(error.getMessage());
        } catch (Exception error) {
            return ResponseEntity.status(500).body(error.getMessage());
        }
    }
}
