package com.example.springboot.service;

import com.example.basicLayout.Exam;
import com.example.basicLayout.Student;
import com.example.basicLayout.Teacher;
import com.example.jdbc.IExamDao;
import com.example.jdbc.IResultDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    ApplicationContext ac =new ClassPathXmlApplicationContext("Bean.xml");
    IResultDao resultDao=ac.getBean("resultDao",IResultDao.class);



    public List<Student> getStuRes(int examId){
        return resultDao.getStuResultsByExamId(examId);
    }


}
