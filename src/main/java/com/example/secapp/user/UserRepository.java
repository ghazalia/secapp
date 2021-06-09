package com.example.secapp.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Account, Long> {

	Optional<Account> findByUsername(String username);

}
