package com.leang.homework002.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
    private String instructorName;
    private String email;
}

