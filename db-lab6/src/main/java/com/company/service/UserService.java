package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.company.dal.repository.UserRepository;
import com.company.models.domain.address.User;

import java.awt.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public UserService getById(Integer id) {
        return userRepository.findById(id).get();
    }

    public UserService getByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    @Transactional
    public UserService create(UserService user) {
        return userRepository.save(user);
    }

    @Transactional
    public void updateById(UserService user, Integer id) {
        UserService updatedUser = userRepository.findById(id).get();
        updatedUser.setNickname(user.getNickname());
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
       userRepository.deleteById(id);
    }
}
