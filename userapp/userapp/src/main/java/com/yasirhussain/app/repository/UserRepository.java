package com.yasirhussain.app.repository;

import com.yasirhussain.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
