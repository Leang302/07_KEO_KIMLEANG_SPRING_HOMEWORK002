package com.leang.homework002.repository;

import com.leang.homework002.entity.model.Course;
import com.leang.homework002.entity.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "courseDescription", column = "course_description"),
            @Result(property = "instructor", column = "instructor_id", one = @One(select = "com.leang.homework002.repository.InstructorRepository.getInstructorById")),
    })
    @Select("""
                select * from courses where course_id=#{courseId};
            """)
    Course getCourseById(Long courseId);

    @ResultMap("courseMapper")
    @Select("""
                select * from courses;
            """)
    List<Course> getAllCourses(int offset, int size);

    @ResultMap("courseMapper")
    @Select("""
                        INSERT INTO courses VALUES (default,#{req.courseName},#{req.description},#{req.instructorId})
            returning *;
            
            """)
    Course addCourse(@Param("req") CourseRequest courseRequest);

    @ResultMap("courseMapper")
    @Select("""
                    UPDATE courses SET course_name=#{req.courseName}, course_description=#{req.description},instructor_id=#{req.instructorId} WHERE course_id=#{courseId} returning *;
            """)
    Course updateCourseById(Long courseId, @Param("req") CourseRequest courseRequest);


    @Delete("""
                    DELETE FROM courses where course_id=#{courseId}
            """)
    void removeCourseByID(Long courseId);
}
