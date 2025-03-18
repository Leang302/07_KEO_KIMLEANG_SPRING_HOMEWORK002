package com.leang.homework002.controller;

import com.leang.homework002.entity.model.Course;
import com.leang.homework002.entity.request.CourseRequest;
import com.leang.homework002.entity.response.ApiResponse;
import com.leang.homework002.service.CourseService;
import com.leang.homework002.utils.HELPER;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Operation(summary = "Get course by course id")
    @GetMapping("{course-id}")
    public ResponseEntity<?> getCourseById(@PathVariable("course-id") Long courseId, WebRequest webRequest) {
        Course courseById = courseService.getCourseById(courseId);
        if (courseById == null) {
            return HELPER.notFoundMessage(courseId, "Course", webRequest);
        }
        return ResponseEntity.ok(ApiResponse.<Course>builder()
                .message("The course has been successfully founded.")
                .payload(courseById)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }

    @Operation(summary = "Update course by course id")
    @PutMapping("{course-id}")
    public ResponseEntity<?> updateCourseById(@PathVariable("course-id") Long courseId, @RequestBody CourseRequest courseRequest, WebRequest webRequest) {
        Course courseById = courseService.getCourseById(courseId);
        if (courseById == null) {
            return HELPER.notFoundMessage(courseId, "Course", webRequest);
        }
        courseService.updateCourseById(courseId, courseRequest);
        return ResponseEntity.ok(ApiResponse.<Course>builder()
                .message("The course has been successfully updated.")
                .payload(courseById)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }

    @Operation(summary = "Remove course by course id")
    @DeleteMapping("{course-id}")
    public ResponseEntity<?> removeCourseById(@PathVariable("course-id") Long courseId, WebRequest webRequest) {
        Course courseById = courseService.getCourseById(courseId);
        if (courseById == null) {
            return HELPER.notFoundMessage(courseId, "Course", webRequest);
        }
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
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourse(@RequestParam(defaultValue = "1") int offset, @RequestParam(defaultValue = "10") int limit) {
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
    public ResponseEntity<?> addCourse(@RequestBody CourseRequest courseRequest) {
        Course course = courseService.addCourse(courseRequest);
        return ResponseEntity.ok(ApiResponse.<Course>builder()
                .message("The course has been successfully added.")
                .payload(course)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }
}
