package com.practice.mapstruct.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class StudentDto {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private int age;
    private String dress;
}
