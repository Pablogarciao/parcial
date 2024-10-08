package com.example.parcial.SERVICES.INTERFACES;

import com.example.parcial.MODELENTITY.PortfolioMedia;

import java.util.List;

public interface IPortfolioMediaService {
    List<PortfolioMedia> findAll();
    PortfolioMedia save(PortfolioMedia portfolioMedia);
    PortfolioMedia findById(Long id);
    void deleteById(Long id);
}
