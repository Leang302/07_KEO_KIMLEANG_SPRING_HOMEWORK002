package com.leang.homework002.service.impl;

import com.leang.homework002.entity.model.Instructor;
import com.leang.homework002.entity.request.InstructorRequest;
import com.leang.homework002.repository.InstructorRepository;
import com.leang.homework002.service.InstructorService;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public List<Instructor> getAllInstructors(int offset, int size) {
        offset = (offset - 1) * size;
        return instructorRepository.getAllInstructors(offset, size);
    }

    @Override
    public Instructor addInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.addInstructor(instructorRequest);
    }

    @Override
    public Instructor updateInstructorById(Long id, InstructorRequest instructorRequest) {
        return instructorRepository.updateInstructorById(id, instructorRequest);
    }

    @Override
    public void removeInstructorByID(Long instructorId) {
        instructorRepository.removeInstructorByID(instructorId);
    }
}
