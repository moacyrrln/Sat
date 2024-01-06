// UserServices.java
package com.sat.users.service;

import com.sat.users.dto.UserDTO;
import com.sat.users.mapper.UserMapper;
import com.sat.users.model.Users;
import com.sat.users.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserMapper userMapper;

  public List<UserDTO> getAllUsers() {
    List<Users> users = userRepository.findAll();

    if (users.isEmpty()) {
      return Collections.emptyList();
    } else {
      return users.stream()
          .map(userMapper::mapToDTO)
          .collect(Collectors.toList());
    }
  }

  public UserDTO getUserById(Long id) {
    Users user = userRepository.findById(id).orElse(null);
    return (user != null) ? userMapper.mapToDTO(user) : null;
  }

  public UserDTO createUser(UserDTO userDTO) {
    Users user = userMapper.mapToEntity(userDTO);
    userRepository.save(user);
    return userMapper.mapToDTO(user);
  }

  public UserDTO updateUser(Long id, UserDTO userDTO) {
    Users existingUser = userRepository.findById(id).orElse(null);

    if (existingUser != null) {
      existingUser.setName(userDTO.getName());
      existingUser.setEmail(userDTO.getEmail());
      userRepository.save(existingUser);
      return userMapper.mapToDTO(existingUser);
    }

    return null;
  }

  public boolean deleteUser(Long userId) {
    Users existingUser = userRepository.findById(userId).orElse(null);

    if (existingUser != null) {
      userRepository.delete(existingUser);
      return true;
    }

    return false;
  }
}

