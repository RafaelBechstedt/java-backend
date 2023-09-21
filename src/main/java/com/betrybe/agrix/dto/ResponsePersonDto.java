package com.betrybe.agrix.dto;

import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.security.Role;

/**
 * Javadoc.
 */
public record ResponsePersonDto(long id, String username, Role role) {

  /**
   * Javadoc.
   */
  public static ResponsePersonDto personToDto(Person person) {
    return new ResponsePersonDto(
        person.getId(),
        person.getUsername(),
        person.getRole());
  }
}