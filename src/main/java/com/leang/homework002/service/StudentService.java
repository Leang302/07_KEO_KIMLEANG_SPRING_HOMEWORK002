package com.leang.homework002.service;

import com.leang.homework002.entity.model.Student;
import com.leang.homework002.entity.request.StudentRequest;

import java.util.List;

public interface StudentService {
    Student getStudentById(Long studentId);

    List<Student> getAllStudents(Integer offset, Integer size);

    Student createStudent(StudentRequest studentRequest);

    Student updateStudentById(Long studentId, StudentRequest studentRequest);

    void removeStudentById(Long studentId);
}
