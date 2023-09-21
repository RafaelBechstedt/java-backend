package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.services.FertilizerService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Define controller Crop.
 */
@RestController
public class CropController {

  private CropService cropService;
  private FertilizerService fertilizerService;

  @Autowired
  public CropController(CropService cropService, FertilizerService fertilizerService) {
    this.cropService = cropService;
    this.fertilizerService = fertilizerService;
  }

  /**
   * Rota POST /farms/farmId/crops.
   */
  @PostMapping("/farms/{farmId}/crops")
  public ResponseEntity<CropDto> save(@RequestBody CropDto cropDto,
      @PathVariable("farmId") long farmId) {
    Crop crop = cropService.save(cropDto.dtoToCrop(), farmId);
    CropDto response = CropDto.cropToDto(crop);
    return ResponseEntity.status(201).body(response);
  }

  /**
   * Rota GET /farms/farmId/crops.
   */
  @GetMapping("/farms/{farmId}/crops")
  public ResponseEntity<List<CropDto>> findCropsByFarmId(@PathVariable("farmId") long farmId) {
    List<Crop> crops = cropService.findCropsByFarmId(farmId);
    List<CropDto> response = crops.stream().map(
        CropDto::cropToDto
    ).toList();
    return ResponseEntity.status(200).body(response);
  }

  /**
   * Rota GET /crops.
   */
  @GetMapping("/crops")
  public ResponseEntity<List<CropDto>> findAll() {
    List<Crop> crops = cropService.findAll();
    List<CropDto> response = crops.stream().map(
        CropDto::cropToDto
    ).toList();
    return ResponseEntity.status(200).body(response);
  }

  /**
   * Rota GET /crops/id.
   */
  @GetMapping("/crops/{id}")
  public ResponseEntity<CropDto> findCropById(@PathVariable("id") long id) {
    Crop crop = cropService.findCropById(id);
    CropDto response = CropDto.cropToDto(crop);
    return ResponseEntity.status(200).body(response);
  }

  /**
   * Rota GET /crops/search.
   */
  @GetMapping("/crops/search")
  public ResponseEntity<List<CropDto>> findCropsByHarvestDate(@RequestParam LocalDate start,
      @RequestParam LocalDate end) {
    List<Crop> crops = cropService.findCropsByHarvestDate(start, end);
    List<CropDto> response = crops.stream().map(
        CropDto::cropToDto
    ).toList();
    return ResponseEntity.status(200).body(response);
  }

  /**
   * Javadoc.
   */
  @PostMapping("/crops/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> create(@PathVariable(name = "cropId") Long cropId,
      @PathVariable(name = "fertilizerId") Long fertilizerId) {
    Crop crop = cropService.findCropById(cropId);
    Fertilizer fertilizer = fertilizerService.findById(fertilizerId);
    crop.addFertilize(fertilizer);
    cropService.insertFertilizer(crop);
    return ResponseEntity.status(201).body("Fertilizante e plantação associados com sucesso!");
  }
}



