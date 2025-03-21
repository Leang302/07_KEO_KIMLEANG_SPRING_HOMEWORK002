package com.leang.homework002.service;

import com.leang.homework002.entity.model.Instructor;
import com.leang.homework002.entity.request.InstructorRequest;

import java.util.List;

public interface InstructorService {
    Instructor getInstructorById(Long instructorId);

    List<Instructor> getAllInstructors(Integer offset, Integer size);

    Instructor addInstructor(InstructorRequest instructorRequest);

    Instructor updateInstructorById(Long instructorId, InstructorRequest instructorRequest);

    void removeInstructorByID(Long instructorId);
}
