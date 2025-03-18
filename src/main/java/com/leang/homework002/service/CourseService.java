package com.leang.homework002.service;

import com.leang.homework002.entity.model.Course;
import com.leang.homework002.entity.request.CourseRequest;

import java.util.List;

public interface CourseService {
    Course getCourseById(Long id);
    Course updateCourseById(Long id, CourseRequest courseRequest);
    void removeCourseById(Long id);
    List<Course> getAllCourses(int offset,int size);
    Course addCourse(CourseRequest courseRequest);
}
