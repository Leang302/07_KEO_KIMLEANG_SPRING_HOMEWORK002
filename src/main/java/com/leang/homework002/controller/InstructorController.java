package com.leang.homework002.controller;

import com.leang.homework002.entity.model.Instructor;
import com.leang.homework002.entity.request.InstructorRequest;
import com.leang.homework002.entity.response.ApiResponse;
import com.leang.homework002.service.InstructorService;
import com.leang.homework002.utils.HELPER;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.service.RequestBodyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @Operation(summary = "Get instructor by instructor id")
    @GetMapping("{instructor-id}")
    public ResponseEntity<?> getInstructorById(@PathVariable("instructor-id") Long instructorId, WebRequest webRequest) {
        Instructor instructor = instructorService.getInstructorById(instructorId);
        if (instructor == null) {
            return HELPER.notFoundMessage(instructorId, "Instructor", webRequest);
        }
        return ResponseEntity.ok(ApiResponse.<Instructor>builder().message("The instructor has been successfully founded.").payload(instructor).status(HttpStatus.OK).time(LocalDateTime.now()).build());
    }

    @Operation(summary = "Get all instructors")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors(@RequestParam(defaultValue = "1") int offset, @RequestParam(defaultValue = "10") int size) {
        List<Instructor> instructors = instructorService.getAllInstructors(offset, size);
        return ResponseEntity.ok(ApiResponse.<List<Instructor>>builder().message("All instructors have been successfully fetched.").payload(instructors).status(HttpStatus.OK).time(LocalDateTime.now()).build());
    }

    @Operation(summary = "Add new instructor")
    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> addInstructor(@RequestBody InstructorRequest instructorRequest) {
        Instructor instructor = instructorService.addInstructor(instructorRequest);
        return ResponseEntity.ok(ApiResponse.<Instructor>builder().message("The instructor has been successfully added.").payload(instructor).status(HttpStatus.OK).time(LocalDateTime.now()).build());
    }

    @Operation(summary = "Update instructor by instructor id")
    @PutMapping("{instructor-id}")
    public ResponseEntity<?> updateInstructor(@PathVariable("instructor-id") Long instructorId, @RequestBody InstructorRequest instructorRequest, WebRequest webRequest) {
        Instructor instructorById = instructorService.getInstructorById(instructorId);
        if (instructorById == null) {
            return HELPER.notFoundMessage(instructorId, "Instructor", webRequest);
        }
        Instructor instructor = instructorService.updateInstructorById(instructorId, instructorRequest);
        return ResponseEntity.ok(ApiResponse.<Instructor>builder().message("The instructor has been successfully updated.").payload(instructor).status(HttpStatus.OK).time(LocalDateTime.now()).build());
    }

    @Operation(summary = "Remove instructor by instructor id")
    @DeleteMapping("{instructor-id}")
    public ResponseEntity<?> removeInstructorById(@PathVariable("instructor-id") Long instructorId, WebRequest webRequest) {
        Instructor instructorById = instructorService.getInstructorById(instructorId);
        if (instructorById == null) {
            return HELPER.notFoundMessage(instructorId, "Instructor", webRequest);
        }
        return ResponseEntity.ok(ApiResponse.builder().message("The instructor has been successfully removed.").status(HttpStatus.OK).time(LocalDateTime.now()).build());
    }

}
