package com.example.service.impl;

import com.example.dao.SigninDao;
import com.example.domain.SignInfo;
import com.example.domain.StudentCourseRelation;
import com.example.domain.StudentInfo;
import com.example.service.SigninService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SigninServiceImpl implements SigninService {

    @Resource
    SigninDao signinDao;

    @Override
    public StudentInfo findByStudentNo(String studentNo){
        return signinDao.findByStudentNo(studentNo);
    }

    @Override public List<StudentCourseRelation> findStudentCoursesByStudentNo(String studentNo) {
        return signinDao.findStudentCoursesByStudentNo(studentNo);
    }

    @Override public void signin(SignInfo signInfo) {
        signinDao.signin(signInfo);
    }

}
