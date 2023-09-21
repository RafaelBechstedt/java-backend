package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dto.FertilizerDto;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.services.FertilizerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Javadoc.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;


  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }


  /**
   * Javadoc.
   */
  @PostMapping
  public ResponseEntity<FertilizerDto> save(@RequestBody FertilizerDto fertilizerDto) {
    Fertilizer fertilizer = fertilizerService.save(fertilizerDto.dtoToFertilizer());
    FertilizerDto response = FertilizerDto.fertilizerToDto(fertilizer);
    return ResponseEntity.status(201).body(response);
  }


  /**
   * Javadoc.
   */
  @GetMapping
  public ResponseEntity<List<FertilizerDto>> findAll() {
    List<Fertilizer> fertilizerList = fertilizerService.findAll();
    List<FertilizerDto> response = fertilizerList.stream()
        .map(FertilizerDto::fertilizerToDto)
        .toList();
    return ResponseEntity.status(200).body(response);
  }

  /**
   * Define rota GET/id.
   */
  @GetMapping("/{id}")
  public ResponseEntity<FertilizerDto> findById(@PathVariable("id") long id) throws CustomError {
    Fertilizer fertilizer = fertilizerService.findById(id);
    FertilizerDto response = FertilizerDto.fertilizerToDto(fertilizer);
    return ResponseEntity.status(200).body(response);
  }
}