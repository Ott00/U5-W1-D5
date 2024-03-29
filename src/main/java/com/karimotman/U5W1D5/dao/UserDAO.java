package com.karimotman.U5W1D5.dao;

import com.karimotman.U5W1D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    boolean existsByName(String name);
}
