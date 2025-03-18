package com.leang.homework002.service.impl;

import com.leang.homework002.entity.model.Course;
import com.leang.homework002.entity.request.CourseRequest;
import com.leang.homework002.repository.CourseRepository;
import com.leang.homework002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Course updateCourseById(Long id, CourseRequest courseRequest) {
        return courseRepository.updateCourseById(id,courseRequest);
    }

    @Override
    public void removeCourseById(Long id) {
        courseRepository.removeCourseByID(id);
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
