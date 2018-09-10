package com.sopra.Factory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.Factory.model.User;



public interface UsersRepository extends JpaRepository<User, String> {

}
