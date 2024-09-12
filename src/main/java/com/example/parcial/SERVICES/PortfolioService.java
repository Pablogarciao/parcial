package com.example.parcial.SERVICES;

import com.example.parcial.DAO.IPortfolioDAO;
import com.example.parcial.DAO.IPortfolioMediaDAO;
import com.example.parcial.DTO.PortfolioDTO;
import com.example.parcial.DTO.PortfolioMediaDTO;
import com.example.parcial.MODELENTITY.Portfolio;
import com.example.parcial.MODELENTITY.PortfolioMedia;
import com.example.parcial.MODELENTITY.User;
import com.example.parcial.SERVICES.INTERFACES.IPortfolioService;
import com.example.parcial.SERVICES.INTERFACES.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService implements IPortfolioService {

    @Autowired
    private IPortfolioDAO portfolioDAO;

    @Autowired
    private IPortfolioMediaDAO portfolioMediaDAO;

    @Autowired
    private IUserService userService;

    @Override
    public List<Portfolio> findAll() {
        return portfolioDAO.findAll();
    }

    @Override
    public Portfolio save(Portfolio portfolio) {
        return portfolioDAO.save(portfolio);
    }

    @Override
    public Portfolio findById(Long id) {
        return portfolioDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        portfolioDAO.deleteById(id);
    }

    @Transactional
    public Portfolio createPortfolio(PortfolioDTO portfolioDTO) {
        // Test User, assuming you fetch the user via the user service
        User user = userService.findById(portfolioDTO.getId_user());

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        // Create a new Portfolio
        Portfolio portfolio = new Portfolio();
        portfolio.setUser(user);
        portfolio.setBiography(portfolioDTO.getBiography());

        // Save the new portfolio
        this.save(portfolio);

        // Optionally, if PortfolioMediaDTO is included in PortfolioDTO, add media
        addMedia(portfolio, portfolioDTO.getMedia());

        return portfolio;
    }

    @Transactional
    public void addMedia(Portfolio portfolio, List<PortfolioMediaDTO> mediaList) {
        if (mediaList != null) {
            for (PortfolioMediaDTO mediaDTO : mediaList) {
                PortfolioMedia portfolioMedia = new PortfolioMedia();
                portfolioMedia.setPortfolio(portfolio);
                portfolioMedia.setMedia(mediaDTO.getMedia());

                // Save each portfolio media
                portfolioMediaDAO.save(portfolioMedia);
            }
        }
    }

    @Transactional
    public Portfolio updatePortfolio(PortfolioDTO portfolioDTO, Long id) {
        Portfolio portfolio = this.findById(id);

        if (portfolio == null) {
            throw new IllegalArgumentException("Portfolio not found");
        }

        // Update the portfolio fields
        portfolio.setBiography(portfolioDTO.getBiography());

        // Save the updated portfolio
        return portfolioDAO.save(portfolio);
    }
}
