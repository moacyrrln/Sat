// UserMapper.java
package com.sat.users.mapper;

import com.sat.users.dto.UserDTO;
import com.sat.users.model.Users;
import org.springframework.stereotype.Component;
@Component
public class UserMapper {
  public UserDTO mapToDTO(Users user) {
    UserDTO userDTO = new UserDTO();
    userDTO.setId(user.getId());
    userDTO.setName(user.getName());
    userDTO.setEmail(user.getEmail());
    return userDTO;
  }

  public Users mapToEntity(UserDTO userDTO) {
    Users user = new Users();
    user.setName(userDTO.getName());
    user.setEmail(userDTO.getEmail());
    return user;
  }
}
