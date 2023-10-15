package com.nocomp.db.sample.repository;

import com.nocomp.db.sample.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}