package com.betrybe.agrix.dto;

import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.security.Role;

/**
 * Javadoc.
 */
public record RequestPersonDto(long id, String username, String password, Role role) {

  /**
   * Javadoc.
   */
  public Person dtoToPerson() {
    Person person = new Person();
    person.setUsername(this.username);
    person.setPassword(this.password);
    person.setRole(this.role);
    return person;
  }
}