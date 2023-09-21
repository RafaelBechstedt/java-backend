package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dto.RequestPersonDto;
import com.betrybe.agrix.dto.ResponsePersonDto;
import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Javadoc.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Javadoc.
   */
  @PostMapping
  public ResponseEntity<ResponsePersonDto> save(@RequestBody RequestPersonDto requestPersonDto) {
    Person person = personService.create(requestPersonDto.dtoToPerson());
    ResponsePersonDto response = ResponsePersonDto.personToDto(person);
    return ResponseEntity.status(201).body(response);
  }
}
