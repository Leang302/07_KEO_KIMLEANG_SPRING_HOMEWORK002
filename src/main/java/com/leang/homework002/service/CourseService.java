package com.leang.homework002.service;

import com.leang.homework002.entity.model.Course;
import com.leang.homework002.entity.request.CourseRequest;

import java.util.List;

public interface CourseService {
    Course getCourseById(Long courseId);

    Course updateCourseById(Long courseId, CourseRequest courseRequest);

    void removeCourseById(Long courseId);

    List<Course> getAllCourses(Integer offset, Integer size);

    Course addCourse(CourseRequest courseRequest);
}
