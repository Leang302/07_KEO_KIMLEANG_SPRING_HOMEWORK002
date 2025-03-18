package com.leang.homework002.service.impl;

import com.leang.homework002.entity.model.Course;
import com.leang.homework002.entity.model.Student;
import com.leang.homework002.entity.request.StudentRequest;
import com.leang.homework002.repository.CourseRepository;
import com.leang.homework002.repository.StudentCourseRepository;
import com.leang.homework002.repository.StudentRepository;
import com.leang.homework002.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentCourseRepository studentCourseRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudents(int offset, int size) {
        offset = (offset - 1) * size;
        return studentRepository.getAllStudents(offset, size);
    }

    @Override
    public Student createStudent(StudentRequest studentRequest) {
        Student student = studentRepository.createStudent(studentRequest);
        for (Long courseId : studentRequest.getCourseIds()) {
            studentCourseRepository.insertStudentCourse(student.getStudentId(), courseId);
        }
        return studentRepository.getStudentById(student.getStudentId());
    }

    @Override
    public Student updateStudentById(Long studentId, StudentRequest studentRequest) {
        Student studentById = getStudentById(studentId);
        List<Course> oldCourses = studentById.getCourses();
        //remove all existing course
        oldCourses.forEach(course -> {
            studentCourseRepository.removeStudentCourse(studentId, course.getCourseId());
        });
        //update student info
        Student student = studentRepository.updateStudentById(studentId, studentRequest);
        //add new course
        for (Long courseId : studentRequest.getCourseIds()) {
            studentCourseRepository.insertStudentCourse(student.getStudentId(), courseId);
        }
        return studentRepository.getStudentById(student.getStudentId());
    }

    @Override
    public void removeStudentById(Long studentId) {
        studentRepository.removeStudentById(studentId);
    }
}
