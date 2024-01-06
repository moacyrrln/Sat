// E:\dev\SAT/users\src\main\java\com\sat/users\controller\UserController.java
package com.sat.users.controller;

import com.sat.users.dto.UserDTO;
import com.sat.users.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    List<UserDTO> users = userService.getAllUsers();

    if (users.isEmpty()) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.ok(users);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
    UserDTO userDTO = userService.getUserById(id);
    return (userDTO != null) ? ResponseEntity.ok(userDTO) : ResponseEntity.notFound().build();
  }


  @PostMapping
  public UserDTO createUser(@RequestBody UserDTO userDTO) {
    return userService.createUser(userDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
    UserDTO updatedUser = userService.updateUser(id, userDTO);
    return (updatedUser != null) ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    boolean deleted = userService.deleteUser(id);
    return (deleted) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
  }
}

