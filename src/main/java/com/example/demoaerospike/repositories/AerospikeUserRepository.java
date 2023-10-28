package com.example.demoaerospike.repositories;

import com.example.demoaerospike.objects.User;
import org.springframework.data.aerospike.repository.AerospikeRepository;

public interface AerospikeUserRepository extends AerospikeRepository<User, Integer> {
}