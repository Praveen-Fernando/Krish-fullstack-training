package com.praveen.rentacar.demoapplication.service;

import com.praveen.rentacar.demoapplication.model.Student;

public interface StudentService {

    Student save(Student student);

    Student fetchStudentById(int id);
}
