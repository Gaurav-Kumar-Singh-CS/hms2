package com.gaurav.zuulgateway.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gaurav.zuulgateway.models.ERole;
import com.gaurav.zuulgateway.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
