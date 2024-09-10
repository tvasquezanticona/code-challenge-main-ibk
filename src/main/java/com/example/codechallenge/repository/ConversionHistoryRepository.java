package com.example.codechallenge.repository;

import com.example.codechallenge.model.entity.ConversionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionHistoryRepository extends JpaRepository<ConversionHistory, Long> {
}
