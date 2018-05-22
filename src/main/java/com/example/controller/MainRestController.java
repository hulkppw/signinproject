package com.example.controller;

import com.example.domain.SignInfo;
import com.example.domain.StudentCourseRelation;
import com.example.domain.StudentInfo;
import com.example.service.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class MainRestController {
    @Autowired
    private SigninService signinService;

    @RequestMapping(value = "/login")
    public String findStudentByStuId(String studentNo, String password) {
        String result = "fail";
        StudentInfo studentInfo = signinService.findByStudentNo(studentNo);
        if (studentInfo != null && studentInfo.getPassword().equals(password)){
            result = "success";
        }
        return result;
    }

    @RequestMapping(value = "/signin/{studentNo}/{courseNo}/{planId}/{longitude}/{latitude}")
    public String signin(@PathVariable("studentNo") String studentNo,@PathVariable("courseNo") String courseNo,
        @PathVariable("planId") String planId, @PathVariable("longitude") String longitude,@PathVariable("latitude") String latitude) {
        SignInfo signInfo = new SignInfo();
        signInfo.setStudentNo(studentNo);
        signInfo.setCourseNo(courseNo);
        signInfo.setPlanId(Integer.parseInt(planId));
        signInfo.setSignTime(new Date());
        signInfo.setLongitude(longitude);
        signInfo.setLatitude(latitude);
        signinService.signin(signInfo);
        return "success";
    }

    @RequestMapping(value = "/course/{studentNo}")
    public List<StudentCourseRelation> findStudentCourseRelation(@PathVariable("studentNo") String studentNo){
        List<StudentCourseRelation> studentCourseRelations = signinService.findStudentCoursesByStudentNo(studentNo);
        return studentCourseRelations;
    }
}
