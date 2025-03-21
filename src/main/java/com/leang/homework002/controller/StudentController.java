package com.leang.homework002.controller;

import com.leang.homework002.entity.model.Student;
import com.leang.homework002.entity.request.StudentRequest;
import com.leang.homework002.entity.response.ApiResponse;
import com.leang.homework002.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @Operation(summary = "Get student by id")
    @GetMapping("{student-id}")
    public ResponseEntity<?> getStudentById(@PathVariable("student-id") Long studentId) {
        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .message("The student has been successfully founded.")
                .payload(student)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }

    @Operation(summary = "Get all student")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent(@RequestParam(defaultValue = "1") @Positive Integer offset, @RequestParam(defaultValue = "10") @Positive Integer size) {
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
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody @Valid StudentRequest studentRequest) {
        Student student = studentService.createStudent(studentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<Student>builder()
                        .message("The student has been successfully added.")
                        .payload(student)
                        .status(HttpStatus.CREATED)
                        .time(LocalDateTime.now())
                        .build());
    }

    @Operation(summary = "Update student by student id")
    @PutMapping("{student-id}")
    public ResponseEntity<?> updateStudentById(@RequestBody @Valid StudentRequest studentRequest, @PathVariable("student-id") Long studentId) {
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
    public ResponseEntity<?> removeStudentById(@PathVariable("student-id") Long studentId) {
        studentService.removeStudentById(studentId);
        return ResponseEntity.ok(ApiResponse.builder()
                .message("The student has been successfully removed.")
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }
}
