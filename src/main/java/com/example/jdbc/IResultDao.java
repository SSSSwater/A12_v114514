package com.example.jdbc;

import com.example.basicLayout.Student;

import java.util.List;

public interface IResultDao {
    public List<Student> getStuResultsByExamId(int examId);

}
