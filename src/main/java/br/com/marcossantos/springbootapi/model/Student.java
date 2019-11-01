package br.com.marcossantos.springbootapi.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Student extends AbstractEntity {
  @NotEmpty(message = "O campo nome do estudante é obrigatório")
  private String name;

  @Email
  @NotEmpty(message = "O campo email é obrigatório")
  private String email;

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}