package com.betrybe.agrix.dto;

import com.betrybe.agrix.models.entities.Fertilizer;

/**
 * Define DTO de Fertilizer.
 */
public record FertilizerDto(long id, String name, String brand, String composition) {

  public static FertilizerDto fertilizerToDto(Fertilizer fertilizer) {
    return new FertilizerDto(fertilizer.getId(), fertilizer.getName(), fertilizer.getBrand(),
        fertilizer.getComposition());
  }

  /**
   * Define método que converte DTO para Fertilizer.
   */
  public Fertilizer dtoToFertilizer() {
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setName(name);
    fertilizer.setBrand(brand);
    fertilizer.setComposition(composition);
    return fertilizer;
  }
}
