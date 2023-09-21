package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Define repositório Crop.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

  List<Crop> findByFarmId(long farmId);

  @Query(value = "SELECT c FROM Crop c WHERE c.harvestDate BETWEEN :start AND :end")
  List<Crop> findCropsByHarvestDate(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
