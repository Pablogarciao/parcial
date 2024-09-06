package com.example.parcial.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.parcial.MODELENTITY.PortfolioMedia;

public interface IPortfolioMediaDAO extends JpaRepository<PortfolioMedia, Long> {
    public List<PortfolioMedia> findByName(String media);
    public List<PortfolioMedia> findByName(String URL);
}
