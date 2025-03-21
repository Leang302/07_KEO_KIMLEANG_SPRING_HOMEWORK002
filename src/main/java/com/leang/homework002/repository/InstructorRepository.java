package com.leang.homework002.repository;

import com.leang.homework002.entity.model.Instructor;
import com.leang.homework002.entity.request.InstructorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {
    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name")
    })
    @Select("""
                    SELECT * FROM instructors WHERE instructor_id= #{instructorId}
            """)
    Instructor getInstructorById(Long instructorId);

    @ResultMap("instructorMapper")
    @Select("""
                    SELECT * FROM instructors OFFSET #{offset} LIMIT #{size};
            """)
    List<Instructor> getAllInstructors(int offset, int size);


    @ResultMap("instructorMapper")
    @Select("""
                    INSERT INTO instructors VALUES(default,#{req.instructorName},#{req.email}) returning *;
            """)
    Instructor addInstructor(@Param("req") InstructorRequest instructorRequest);

    @ResultMap("instructorMapper")
    @Select("""
                    UPDATE instructors set instructor_name=#{req.instructorName},email=#{req.email} WHERE instructor_id=#{instructorId} returning *;
            """)
    Instructor updateInstructorById(Long instructorId,@Param("req") InstructorRequest instructorRequest);

@Delete("""
    DELETE FROM instructors WHERE instructor_id=#{instructorId};
""")
    void removeInstructorByID(Long instructorId);
}
