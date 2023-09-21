package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Define repositório Fertilizer.
 */
@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

}
