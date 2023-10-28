package com.example.demoaerospike.service;

import com.example.demoaerospike.objects.User;
import com.example.demoaerospike.repositories.AerospikeUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@AllArgsConstructor
public class UserService {
    AerospikeUserRepository aerospikeUserRepository;
    public Optional<User> readUserById(int id) {
        return aerospikeUserRepository.findById(id);
    }
    public void addUser(User user) {
        aerospikeUserRepository.save(user);
    }
    public void removeUserById(int id) {
        aerospikeUserRepository.deleteById(id);
    }
}