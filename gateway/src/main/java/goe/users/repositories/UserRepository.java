package goe.users.repositories;

import org.springframework.data.repository.CrudRepository;

import goe.users.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
}
