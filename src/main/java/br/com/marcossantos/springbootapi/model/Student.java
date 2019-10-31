package br.com.marcossantos.springbootapi.model;

import javax.persistence.Entity;


@Entity
public class Student extends AbstractEntity {
  private String name;

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
}