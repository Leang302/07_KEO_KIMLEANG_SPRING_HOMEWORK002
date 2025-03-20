package com.leang.homework002.service.impl;

import com.leang.homework002.entity.model.Course;
import com.leang.homework002.entity.request.CourseRequest;
import com.leang.homework002.exception.NotFoundException;
import com.leang.homework002.repository.CourseRepository;
import com.leang.homework002.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course getCourseById(Long courseId) {
        Course courseById = courseRepository.getCourseById(courseId);
        if (courseById == null) {
            throw new NotFoundException("Course with id " + courseId);
        }
        return courseById;
    }

    @Override
    public Course updateCourseById(Long courseId, CourseRequest courseRequest) {
        getCourseById(courseId);
        return courseRepository.updateCourseById(courseId, courseRequest);
    }

    @Override
    public void removeCourseById(Long courseId) {
        getCourseById(courseId);
        courseRepository.removeCourseByID(courseId);
    }

    @Override
    public List<Course> getAllCourses(int offset, int size) {
        offset = (offset - 1) * size;
        return courseRepository.getAllCourses(offset, size);
    }

    @Override
    public Course addCourse(CourseRequest courseRequest) {
        return courseRepository.addCourse(courseRequest);
    }
}
