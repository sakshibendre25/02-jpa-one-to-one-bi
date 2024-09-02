package com.sakshi.cruuddemo.dao;

import com.sakshi.cruuddemo.entity.Instructor;
import com.sakshi.cruuddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailsById(int theId);
}

