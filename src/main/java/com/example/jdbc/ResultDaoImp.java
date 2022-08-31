package com.example.jdbc;

import com.example.basicLayout.Paper;
import com.example.basicLayout.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class ResultDaoImp extends JdbcDaoSupport implements IResultDao{
    @Override
    public List<Student> getStuResultsByExamId(int examId) {
        List<Student> students= getJdbcTemplate().query("select id,name,classnum,res from results where examid = ?",new BeanPropertyRowMapper<Student>(Student.class),examId);
        return students;
    }


}
