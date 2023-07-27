package com.amtechnology.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amtechnology.dscommerce.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	


}
