package com.leang.homework002.controller;

import com.leang.homework002.entity.model.Student;
import com.leang.homework002.entity.request.StudentRequest;
import com.leang.homework002.entity.response.ApiResponse;
import com.leang.homework002.service.StudentService;
import com.leang.homework002.utils.HELPER;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Get student by id")
    @GetMapping("{student-id}")
    public ResponseEntity<?> getStudentById(@PathVariable("student-id") Long studentId, WebRequest webRequest) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            return HELPER.notFoundMessage(studentId, "Student", webRequest);
        }
        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .message("The student has been successfully founded.")
                .payload(student)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }

    @Operation(summary = "Get all student")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent(@RequestParam(defaultValue = "1") int offset, @RequestParam(defaultValue = "10") int size) {
        List<Student> allStudents = studentService.getAllStudents(offset, size);
        return ResponseEntity.ok(ApiResponse.<List<Student>>builder()
                .message("The student has been successfully fetched.")
                .payload(allStudents)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }

    @Operation(summary = "Create new student")
    @PostMapping
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody StudentRequest studentRequest) {
        Student student = studentService.createStudent(studentRequest);
        return ResponseEntity.ok(
                ApiResponse.<Student>builder()
                        .message("The student has been successfully added.")
                        .payload(student)
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build());
    }

    @Operation(summary = "Update student by student id")
    @PutMapping("{student-id}")
    public ResponseEntity<?> updateStudentById(@RequestBody StudentRequest studentRequest, @PathVariable("student-id") Long studentId, WebRequest webRequest) {
        Student studentById = studentService.getStudentById(studentId);
        if (studentById == null) {
            return HELPER.notFoundMessage(studentId, "Student", webRequest);
        }
        Student student = studentService.updateStudentById(studentId, studentRequest);

        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .message("The student has been successfully updated.")
                .payload(student)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }

    @Operation(summary = "Delete student by student id")
    @DeleteMapping("{student-id}")
    public ResponseEntity<?> removeStudentById(@PathVariable("student-id") Long studentId, WebRequest webRequest) {
        Student studentById = studentService.getStudentById(studentId);
        if (studentById == null) {
            return HELPER.notFoundMessage(studentId, "Student", webRequest);
        }
        studentService.removeStudentById(studentId);
        return ResponseEntity.ok(ApiResponse.builder()
                .message("The student has been successfully removed.")
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }
}
