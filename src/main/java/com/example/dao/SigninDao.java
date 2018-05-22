package com.example.dao;

import com.example.domain.SignInfo;
import com.example.domain.StudentCourseRelation;
import com.example.domain.StudentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SigninDao {

    public StudentInfo findByStudentNo(String studentNo);

    public List<StudentCourseRelation> findStudentCoursesByStudentNo(String studentNo);

    public void signin(SignInfo signInfo);
}
