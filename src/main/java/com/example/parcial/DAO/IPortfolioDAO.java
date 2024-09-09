package com.example.parcial.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.parcial.MODELENTITY.Portfolio;
import java.util.List;

public interface IPortfolioDAO extends JpaRepository<Portfolio, Long> {
//    public List<Portfolio> findByName(String biography);
}
