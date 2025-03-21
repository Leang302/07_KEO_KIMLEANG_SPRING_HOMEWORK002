package com.leang.homework002.repository;

import com.leang.homework002.entity.model.Student;
import com.leang.homework002.entity.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id", many = @Many(select = "com.leang.homework002.repository.StudentCourseRepository.getCoursesByStudentId"))
    })
    @Select("""
                    select * from students where student_id=#{studentId}
            """)
    Student getStudentById(Long studentId);

    @ResultMap("studentMapper")
    @Select("""
                    SELECT * FROM STUDENTS OFFSET #{offset} LIMIT #{size};
            """)
    List<Student> getAllStudents(int offset, int size);

    @ResultMap("studentMapper")
    @Select("""
                    INSERT INTO students VALUES(default,#{req.studentName},#{req.email},#{req.phoneNumber}) returning *;
            """)
    Student createStudent(@Param("req") StudentRequest studentRequest);

    @ResultMap("studentMapper")
    @Select("""
            UPDATE students SET student_name=#{req.studentName},email=#{req.email},phone_number=#{req.phoneNumber} WHERE student_id=#{studentId} returning *;
            """)
    Student updateStudentById(Long studentId,@Param("req") StudentRequest studentRequest);

    @Delete("""
                    DELETE FROM students where student_id=#{studentId};
            """)
    void removeStudentById(Long studentId);
}
