package com.leang.homework002.service.impl;

import com.leang.homework002.entity.model.Instructor;
import com.leang.homework002.entity.request.InstructorRequest;
import com.leang.homework002.exception.NotFoundException;
import com.leang.homework002.repository.InstructorRepository;
import com.leang.homework002.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    @Override
    public Instructor getInstructorById(Long instructorId) {
        Instructor instructorById = instructorRepository.getInstructorById(instructorId);
        if (instructorById == null) {
            throw new NotFoundException("Instructor with id " + instructorId);
        }
        return instructorById;
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
    public Instructor updateInstructorById(Long instructorId, InstructorRequest instructorRequest) {
        getInstructorById(instructorId);
        return instructorRepository.updateInstructorById(instructorId, instructorRequest);
    }

    @Override
    public void removeInstructorByID(Long instructorId) {
        getInstructorById(instructorId);
        instructorRepository.removeInstructorByID(instructorId);
    }
}
