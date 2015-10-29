package com.goe.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.goe.users.models.User;

@Component
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
}
