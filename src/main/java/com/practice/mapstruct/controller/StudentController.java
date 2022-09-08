package com.practice.mapstruct.controller;

import com.practice.mapstruct.dto.StudentDto;
import com.practice.mapstruct.mapper.StudentMapper;
import com.practice.mapstruct.model.Student;
import com.practice.mapstruct.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(value ="/students")
    public ResponseEntity<Student> save(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentRepository.save(
           studentMapper.dtoToModel(studentDto)), HttpStatus.CREATED);
    }

    @GetMapping(value ="/students")
    public ResponseEntity<List<StudentDto>> findAll(){
        return  new ResponseEntity<>(studentMapper.modelsTODtos(studentRepository.findAll()),HttpStatus.OK);
    }

    @GetMapping(value ="/students/{id}")
    public ResponseEntity<StudentDto> findById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(studentMapper.modelTODto(studentRepository.findById(id).get()),HttpStatus.OK);
    }

    @DeleteMapping(value ="/students/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id){
        StudentDto studentDto = studentMapper.modelTODto(studentRepository.findById(id).get());
        studentRepository.deleteById(studentDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
