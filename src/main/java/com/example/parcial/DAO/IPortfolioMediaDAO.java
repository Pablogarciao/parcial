package com.example.parcial.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.parcial.MODELENTITY.PortfolioMedia;
import java.util.List;

public interface IPortfolioMediaDAO extends JpaRepository<PortfolioMedia, Long> {
//   List<PortfolioMedia> findByName(String media);
}
