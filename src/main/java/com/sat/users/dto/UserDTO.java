// E:\dev\SAT/users\src\main\java\com\sat/users\dto\UserDTO.java
package com.sat.users.dto;

public class UserDTO {
  private Long Id;
  private String name;
  private String email;

  public UserDTO(Long id, String name, String email) {
    Id = id;
    this.name = name;
    this.email = email;
  }

  public UserDTO() {
  }

  public UserDTO(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
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
}
