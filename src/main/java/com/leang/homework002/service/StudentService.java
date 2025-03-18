package com.leang.homework002.service;

import com.leang.homework002.entity.model.Student;
import com.leang.homework002.entity.request.StudentRequest;

import java.util.List;

public interface StudentService {
    Student getStudentById(Long id);
    List<Student> getAllStudents(int offset,int size);
    Student createStudent(StudentRequest studentRequest);
    Student updateStudentById(Long studentId,StudentRequest studentRequest);

    void removeStudentById(Long studentId);
}
