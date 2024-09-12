package com.example.parcial.SERVICES.INTERFACES;

import java.util.List;
import com.example.parcial.MODELENTITY.Portfolio;
import com.example.parcial.DTO.PortfolioDTO;

public interface IPortfolioService {
    List<Portfolio> findAll();
    Portfolio findById(Long id);
    Portfolio save(Portfolio portfolio);

    void deleteById(Long id);

    // Add update method
    Portfolio updatePortfolio(PortfolioDTO portfolioDTO, Long id);
    Portfolio createPortfolio(PortfolioDTO portfolioDTO);

}
