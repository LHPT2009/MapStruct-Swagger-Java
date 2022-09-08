package com.practice.mapstruct.mapper;

import com.practice.mapstruct.dto.StudentDto;
import com.practice.mapstruct.model.Student;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",imports = UUID.class)
public interface StudentMapper {

    StudentDto modelTODto (Student student);

    List<StudentDto> modelsTODtos (List<Student> student);

    @InheritInverseConfiguration
    Student dtoToModel (StudentDto studentDto);
}

