package com.leang.homework002.service;

import com.leang.homework002.entity.model.Instructor;
import com.leang.homework002.entity.request.InstructorRequest;

import java.util.List;

public interface InstructorService {
    Instructor getInstructorById(Long id);
    List<Instructor> getAllInstructors(int offset, int size);
    Instructor addInstructor(InstructorRequest instructorRequest);
    Instructor updateInstructorById(Long id,InstructorRequest instructorRequest);
    void removeInstructorByID(Long instructorId);
}
