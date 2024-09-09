package com.example.parcial.SERVICES;

import com.example.parcial.DAO.IPortfolioDAO;
import com.example.parcial.MODELENTITY.Portfolio;
import com.example.parcial.SERVICES.INTERFACES.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService implements IPortfolioService {

    @Autowired
    private IPortfolioDAO portfolioDAO;

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
}
