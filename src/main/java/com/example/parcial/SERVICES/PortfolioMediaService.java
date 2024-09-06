package com.example.parcial.SERVICES;

import com.example.parcial.DAO.IPortfolioMediaDAO;
import com.example.parcial.MODELENTITY.PortfolioMedia;
import com.example.parcial.SERVICES.INTERFACES.IPortfolioMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioMediaService implements IPortfolioMediaService {

    @Autowired
    private IPortfolioMediaDAO portfolioMediaDAO;

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
}
