package com.leang.homework002.entity.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    @NotBlank
    @NotNull
    @Size(min = 5, max = 50)
    private String studentName;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @NotNull
    @Size(max=55)
    private String phoneNumber;
    @NotNull
    List<Long> courseIds;
}

