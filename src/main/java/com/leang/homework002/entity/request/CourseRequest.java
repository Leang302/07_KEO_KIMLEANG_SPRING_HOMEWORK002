package com.leang.homework002.entity.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    @NotNull
    @NotBlank
    @Size(min = 5, max = 50)
    private String courseName;
    @Size(min = 0, max = 255, message = "Description must be between 0-255")
    private String description;
    @NotNull
    @Positive
    private Long instructorId;
}
