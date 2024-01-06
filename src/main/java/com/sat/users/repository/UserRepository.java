// UserRepository.java (Repository)
package com.sat.users.repository;

import com.sat.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
