package com.leang.homework002.repository;

import com.leang.homework002.entity.model.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentCourseRepository {
    @Results(id = "resultMapper", value = {@Result(property = "courseId", column = "course_id"), @Result(property = "courseName", column = "course_name"), @Result(property = "courseDescription", column = "course_description"), @Result(property = "instructor", column = "instructor_id", one = @One(select = "com.leang.homework002.repository.InstructorRepository.getInstructorById"))})
    @Select("""
                   SELECT * FROM student_course st inner join courses c on st.course_id=c.course_id where student_id=#{studentId};
            """)
    List<Course> getCoursesByStudentId(Long studentId);

    @Insert("""
                    INSERT INTO student_course VALUES (DEFAULT,#{studentId},#{courseId});
            """)
    void insertStudentCourse(Long studentId, Long courseId);

    @Delete("""
            DELETE FROM student_course where student_id=#{studentId} AND course_id=#{courseId};
            """)
    void removeStudentCourse(Long studentId, Long courseId);
}
