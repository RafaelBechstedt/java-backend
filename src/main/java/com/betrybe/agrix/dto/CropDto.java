package com.betrybe.agrix.dto;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import java.time.LocalDate;

/**
 * Define DTO de Crop.
 */
public record CropDto(long id, String name, double plantedArea, long farmId, LocalDate plantedDate,
                      LocalDate harvestDate) {

  public static CropDto cropToDto(Crop crop) {
    return new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(), crop.getFarm().getId(),
        crop.getPlantedDate(), crop.getHarvestDate());
  }

  /**
   * Define método que converte DTO para Crop.
   */
  public Crop dtoToCrop() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    Farm farm = new Farm();
    farm.setId(farmId);
    crop.setFarm(farm);
    crop.setHarvestDate(harvestDate);
    crop.setPlantedDate(plantedDate);

    return crop;
  }
}
