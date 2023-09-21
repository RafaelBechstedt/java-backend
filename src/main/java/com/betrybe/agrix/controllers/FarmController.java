package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dto.FarmDto;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Define controller Farm.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private FarmService farmService;

  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Define rota POST.
   */
  @PostMapping
  public ResponseEntity<FarmDto> save(@RequestBody FarmDto farmDto) {
    Farm farm = farmService.save(farmDto.dtoToFarm());
    FarmDto response = FarmDto.farmToDto(farm);
    return ResponseEntity.status(201).body(response);
  }

  /**
   * Define rota GET.
   */
  @GetMapping
  public ResponseEntity<List<FarmDto>> findAll() {
    List<Farm> farms = farmService.findAll();
    List<FarmDto> response = farms.stream().map(
        FarmDto::farmToDto
    ).toList();
    return ResponseEntity.status(200).body(response);
  }

  /**
   * Define rota GET/id.
   */
  @GetMapping("/{id}")
  public ResponseEntity<FarmDto> findById(@PathVariable("id") long id) throws CustomError {
    Farm farm = farmService.findById(id);
    FarmDto response = FarmDto.farmToDto(farm);
    return ResponseEntity.status(200).body(response);
  }
}
