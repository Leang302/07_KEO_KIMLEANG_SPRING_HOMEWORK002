package com.leang.homework002.entity.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
    @NotBlank
    @NotNull
    @Size(max = 50)
    private String instructorName;
    @NotNull
    @NotBlank
    @Email
    @Size(max = 50)
    private String email;
}

