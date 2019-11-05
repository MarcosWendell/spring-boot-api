package br.com.marcossantos.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcossantos.springbootapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}