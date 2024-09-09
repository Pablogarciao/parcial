package com.example.parcial.SERVICES.INTERFACES;

import java.util.List;
import com.example.parcial.MODELENTITY.Portfolio;

public interface IPortfolioService {
    List<Portfolio> findAll();
    Portfolio findById(Long id);
    Portfolio save(Portfolio portfolio);
    void deleteById(Long id);
}
