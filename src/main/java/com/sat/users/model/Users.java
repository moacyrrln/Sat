//E:\dev\SAT/users\src\main\java\com\sat/users\model\Users.java
package com.sat.users.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  private String name;

  public Users(Long id, String name, String email) {
    this.Id = id;
    this.name = name;
    this.email = email;
  }

  public Users() {
  }

  public Users(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    this.Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  private String email;
}
