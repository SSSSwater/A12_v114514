package com.example.springboot.controller;

import com.example.basicLayout.Exam;
import com.example.basicLayout.Student;
import com.example.springboot.service.ExamService;
import com.example.springboot.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ResultController {

    @Autowired
    ResultService resultService;
    @Autowired
    ExamService examService;

    @RequestMapping("/teacher/result_management.html")
    public String toResult() {
        return "/teacher/result_management";
    }


    @ResponseBody
    @RequestMapping("/teacher/result_management")
    public Object doTeaResult(HttpServletResponse response) {

        // 跨域支持
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        return resultService.getAllExam();
    }


    @ResponseBody
    @RequestMapping(value = "/teacher/result_management_sub", params = "stclass")
    public Object manageSubClass(HttpServletRequest request,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // TODO 老师管理指定班级学生的考试结果（需要根据examid获取成绩数据表）


        return "/teacher/result_management_sub.html";
    }

    @ResponseBody
    @RequestMapping(value = "/teacher/result_management_sub")
    public Object manageSub(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        return examService.getExam(Integer.parseInt(request.getParameter("examid")));
    }


    @RequestMapping("/teacher/result_management_sub.html")
    public String toSub() {
        return "/teacher/result_management_sub";
    }


    @RequestMapping("/student/my_result.html")
    public String toStuResult() {
        return "/student/my_result";
    }

    @ResponseBody
    @RequestMapping("/student/my_result")
    public Object doStuResult(HttpServletRequest request,HttpServletResponse response) {
        // 跨域支持
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        return resultService.getStuExam((Student) request.getSession().getAttribute("loginUser"));
    }

    @RequestMapping("/student/result_management_sub.html")
    public String toStuResultSub() {
        return "/student/result_management_sub";
    }

    @ResponseBody
    @RequestMapping("/student/result_management_sub")
    public Object doStuResultSub(HttpServletRequest request, HttpServletResponse response) {
        // 跨域支持
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        return examService.getExam(Integer.parseInt(request.getParameter("examid")));
    }

}
