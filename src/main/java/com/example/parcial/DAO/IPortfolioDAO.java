package com.example.parcial.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.parcial.MODELENTITY.Portfolio;

public interface IPortfolioDAO extends JpaRepository<Portfolio, Long> {
    public List<Portfolio> findByName(String biography);
}
