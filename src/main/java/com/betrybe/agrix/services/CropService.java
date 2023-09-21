package com.betrybe.agrix.services;

import com.betrybe.agrix.controllers.CustomError;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Define service de Farm.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FarmRepository farmRepository;

  @Autowired
  public CropService(CropRepository cropRepository, FarmRepository farmRepository) {
    this.cropRepository = cropRepository;
    this.farmRepository = farmRepository;
  }

  /**
   * Javadoc.
   */
  public Crop save(Crop crop, long farmId) {
    Optional<Farm> farm = farmRepository.findById(farmId);
    if (farm.isEmpty()) {
      throw new CustomError("Fazenda não encontrada!");
    } else {
      crop.setFarm(farm.get());
      return cropRepository.save(crop);
    }
  }

  /**
   * Javadoc.
   */
  public List<Crop> findCropsByFarmId(long farmId) {
    Optional<Farm> farm = farmRepository.findById(farmId);
    if (farm.isEmpty()) {
      throw new CustomError("Fazenda não encontrada!");
    } else {
      return cropRepository.findByFarmId(farmId);
    }
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  /**
   * Javadoc.
   */
  public Crop findCropById(long id) {
    Optional<Crop> crop = cropRepository.findById(id);
    if (crop.isEmpty()) {
      throw new CustomError("Plantação não encontrada!");
    } else {
      return crop.get();
    }
  }

  public List<Crop> findCropsByHarvestDate(LocalDate start, LocalDate end) {
    return cropRepository.findCropsByHarvestDate(start, end);
  }

  public void insertFertilizer(Crop crop) {
    cropRepository.save(crop);
  }
}