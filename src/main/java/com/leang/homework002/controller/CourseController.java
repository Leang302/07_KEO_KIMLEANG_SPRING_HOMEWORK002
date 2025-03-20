package com.leang.homework002.controller;

import com.leang.homework002.entity.model.Course;
import com.leang.homework002.entity.request.CourseRequest;
import com.leang.homework002.entity.response.ApiResponse;
import com.leang.homework002.service.CourseService;
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
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @Operation(summary = "Get course by course id")
    @GetMapping("{course-id}")
    public ResponseEntity<?> getCourseById(@PathVariable("course-id") Long courseId) {
        Course courseById = courseService.getCourseById(courseId);
        return ResponseEntity.ok(ApiResponse.<Course>builder()
                .message("The course has been successfully founded.")
                .payload(courseById)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }

    @Operation(summary = "Update course by course id")
    @PutMapping("{course-id}")
    public ResponseEntity<?> updateCourseById(@PathVariable("course-id") Long courseId, @RequestBody @Valid CourseRequest courseRequest) {
        Course course = courseService.updateCourseById(courseId, courseRequest);
        return ResponseEntity.ok(ApiResponse.<Course>builder()
                .message("The course has been successfully updated.")
                .payload(course)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }

    @Operation(summary = "Remove course by course id")
    @DeleteMapping("{course-id}")
    public ResponseEntity<?> removeCourseById(@PathVariable("course-id") Long courseId) {
        courseService.removeCourseById(courseId);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("The course has been successfully removed.")
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }

    @Operation(summary = "Get all courses")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourse(@RequestParam(defaultValue = "1") @Positive int offset, @RequestParam(defaultValue = "10") @Positive int limit) {
        List<Course> allCourses = courseService.getAllCourses(offset, limit);
        return ResponseEntity.ok(ApiResponse.<List<Course>>builder()
                .message("All courses have been successfully fetched.")
                .payload(allCourses)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }

    @Operation(summary = "Create new course")
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody @Valid CourseRequest courseRequest) {
        Course course = courseService.addCourse(courseRequest);
        return ResponseEntity.ok(ApiResponse.<Course>builder()
                .message("The course has been successfully added.")
                .payload(course)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }
}
