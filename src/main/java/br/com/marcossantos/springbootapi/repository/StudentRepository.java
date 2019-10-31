package br.com.marcossantos.springbootapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcossantos.springbootapi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  List<Student> findByName(String name);
}