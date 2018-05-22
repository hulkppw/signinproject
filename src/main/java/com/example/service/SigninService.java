package com.example.service;

import com.example.domain.SignInfo;
import com.example.domain.StudentCourseRelation;
import com.example.domain.StudentInfo;

import java.util.List;


public interface SigninService {
    public StudentInfo findByStudentNo(String studentNo);

    public List<StudentCourseRelation> findStudentCoursesByStudentNo(String studentNo);

    public void signin(SignInfo signInfo);
}
