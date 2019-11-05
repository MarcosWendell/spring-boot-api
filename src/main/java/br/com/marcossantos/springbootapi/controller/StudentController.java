package br.com.marcossantos.springbootapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcossantos.springbootapi.error.ResourceNotFoundException;
import br.com.marcossantos.springbootapi.model.Student;
import br.com.marcossantos.springbootapi.repository.StudentRepository;

@RestController
@RequestMapping("v1")
public class StudentController {
  private final StudentRepository studentDAO;

  @Autowired
  public StudentController(StudentRepository studentDAO) {
    this.studentDAO = studentDAO;
  }

  @GetMapping(path = "protected/student")
  public ResponseEntity<?> listAll(Pageable pageable) {
    return new ResponseEntity<>(studentDAO.findAll(pageable), HttpStatus.OK);
  }

  @GetMapping(path = "protected/student/{id}")
  public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
    Optional<Student> student = studentDAO.findById(id);
    if (!student.isPresent()) {
      throw new ResourceNotFoundException("Student not found for ID: " + id);
    }
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  @GetMapping(path = "protected/student/findByName/{name}")
  public ResponseEntity<?> getStudentByName(@PathVariable("name") String name) {
    List<Student> student = studentDAO.findByNameIgnoreCaseContaining(name);
    if (student.isEmpty()) {
      throw new ResourceNotFoundException("Student not found for name: " + name);
    }
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  @PostMapping(path="admin/student")
  public ResponseEntity<?> save(@Valid @RequestBody Student student) {
    return new ResponseEntity<>(studentDAO.save(student), HttpStatus.OK);
  }

  @PutMapping(path = "admin/student/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Student student) {
    Optional<Student> oldStudent = studentDAO.findById(id);
    if (!oldStudent.isPresent()) {
      throw new ResourceNotFoundException("Student not found");
    }
    Student newStudent = oldStudent.get();
    newStudent.setName(student.getName());
    studentDAO.save(newStudent);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(path = "admin/student/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    studentDAO.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}