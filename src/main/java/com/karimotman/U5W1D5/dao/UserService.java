package com.karimotman.U5W1D5.dao;

import com.karimotman.U5W1D5.entities.User;
import com.karimotman.U5W1D5.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void save(User user) {
        if (userDAO.existsByName(user.getUsername())) {
            throw new RuntimeException("Nome già assegnato!");
        } else {
            userDAO.save(user);
            log.info("Utente salvato correttamente!");
        }
    }

    public User findById(long userId) {
        return userDAO.findById(userId).orElseThrow(() -> new ItemNotFoundException(userId));
    }
}
