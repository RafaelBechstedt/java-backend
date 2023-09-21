package com.betrybe.agrix.dto;

import com.betrybe.agrix.models.entities.Farm;

/**
 * Define DTO de Farm.
 */
public record FarmDto(long id, String name, double size) {

  public static FarmDto farmToDto(Farm farm) {
    return new FarmDto(farm.getId(), farm.getName(), farm.getSize());
  }

  /**
   * Define método que converte DTO para Farm.
   */
  public Farm dtoToFarm() {
    Farm farm = new Farm();
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }
}
