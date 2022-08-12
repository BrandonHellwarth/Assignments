package com.BrandonHellwarth.LoginAndRegistration.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BrandonHellwarth.LoginAndRegistration.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	Optional<User> findByEmail(String email);
//	Optional<User> findByUserName(String UserName);
	//How could you make a find ByUserName to check if a username already exists?
}
