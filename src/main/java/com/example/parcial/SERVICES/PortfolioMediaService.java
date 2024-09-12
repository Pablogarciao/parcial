package com.example.parcial.SERVICES;

import com.example.parcial.DAO.IPortfolioMediaDAO;
import com.example.parcial.DTO.PortfolioMediaDTO;
import com.example.parcial.MODELENTITY.Portfolio;
import com.example.parcial.MODELENTITY.PortfolioMedia;
import com.example.parcial.SERVICES.INTERFACES.IPortfolioMediaService;
import com.example.parcial.SERVICES.INTERFACES.IPortfolioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioMediaService implements IPortfolioMediaService {

    @Autowired
    private IPortfolioMediaDAO portfolioMediaDAO;

    @Autowired
    private IPortfolioService portfolioService;

    @Override
    public List<PortfolioMedia> findAll() {
        return portfolioMediaDAO.findAll();
    }

    @Override
    public PortfolioMedia save(PortfolioMedia portfolioMedia) {
        return portfolioMediaDAO.save(portfolioMedia);
    }

    @Override
    public PortfolioMedia findById(Long id) {
        return portfolioMediaDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        portfolioMediaDAO.deleteById(id);
    }

    @Transactional
    public PortfolioMedia createPortfolioMedia(PortfolioMediaDTO portfolioMediaDTO) {
        // Fetch the portfolio using the ID from the DTO
        Portfolio portfolio = portfolioService.findById(portfolioMediaDTO.getId_portfolio());

        if (portfolio == null) {
            throw new IllegalArgumentException("Portfolio not found");
        }

        // Create and set the new portfolio media
        PortfolioMedia portfolioMedia = new PortfolioMedia();
        portfolioMedia.setPortfolio(portfolio);
        portfolioMedia.setMedia(portfolioMediaDTO.getMedia());

        // Save the portfolio media
        return portfolioMediaDAO.save(portfolioMedia);
    }

    @Transactional
    public PortfolioMedia updatePortfolioMedia(PortfolioMediaDTO portfolioMediaDTO, Long id) {
        // Find the existing portfolio media
        PortfolioMedia existingMedia = this.findById(id);

        if (existingMedia == null) {
            throw new IllegalArgumentException("PortfolioMedia not found with id: " + id);
        }

        // Update the media field
        existingMedia.setMedia(portfolioMediaDTO.getMedia());

        // Save the updated portfolio media
        return portfolioMediaDAO.save(existingMedia);
    }
}
