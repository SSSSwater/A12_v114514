package com.example.springboot.controller;

import com.example.basicLayout.Exam;
import com.example.basicLayout.Student;
import com.example.springboot.service.ExamService;
import com.example.springboot.service.PaperService;
import com.mysql.cj.Session;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class ExamController {

    @Autowired
    ExamService examService;

    @Autowired
    PaperService paperService;

    @RequestMapping("/teacher/exam_public.html")
    public String toPublic() {
        return "/teacher/exam_public";
    }

    @ResponseBody
    @RequestMapping("/teacher/exam_public")
    public Object doPublic(HttpServletResponse response) {

        // 跨域支持
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return paperService.getAllPaper();
    }


    @RequestMapping(value = "/teacher/exam_public_sub")
    public Object doPublicSub(HttpServletRequest request) {



        Exam exam = new Exam();
        exam.setName(request.getParameter("name"));
        exam.setPaperId(request.getIntHeader("paperid"));
        exam.setExamClass(request.getParameter("examclass"));
        exam.setStartTime(request.getParameter("starttime"));
        exam.setEndTime(request.getParameter("endtime"));
        exam.setFinish(0);

        examService.postExam(exam);
        log.info(exam.toString());

        return "/teacher/exam_public_sub.html";
    }

    @RequestMapping(value = "/teacher/exam_public_sub.html")
    public String toPublicSub() {

        return "/teacher/exam_public_sub";
    }



    @ResponseBody
    @RequestMapping("/student/my_exam")
    public Object doMyExam(HttpServletRequest request,HttpServletResponse response){
        // 跨域支持
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        Student student=(Student) request.getSession().getAttribute("loginUser");

        return examService.getStuExam(student.getId());
    }


    @RequestMapping("/student/my_exam.html")
    public String toMyExam(){
        return "/student/my_exam";
    }

    @RequestMapping("/student/my_exam_sub.html")
    public String toMyExamSub(){
        return "/student/my_exam_sub";
    }


    //打开网页时返回考试具体信息
    @ResponseBody
    @RequestMapping(value = "/student/my_exam_sub",method = RequestMethod.GET)
    public Object doMyExamSub(HttpServletRequest request,HttpServletResponse response){
        // 跨域支持
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        return paperService.previewPaper(examService.getExam(Integer.parseInt(request.getParameter("examid"))).getPaperId());
    }


    //接收提交的考试信息
    @RequestMapping(value = "/student/my_exam_sub",method = RequestMethod.POST)
    public String doGetExamSub(HttpServletRequest request){
        //TODO 接收学生作答情况数据



        //TODO 将学生作答试卷情况保存入数据库



        return "/student/my_exam_sub.html";
    }



}
