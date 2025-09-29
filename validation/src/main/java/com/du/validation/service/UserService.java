package com.du.validation.service;

import com.du.validation.entity.UserEntity;
import com.du.validation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    public void save(UserEntity user){
        userRepository.save(user);
    }

    public void delete(UserEntity user){
        userRepository.delete(user);
    }
}
