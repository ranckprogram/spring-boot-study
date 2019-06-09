package com.ranck.study.dao;

import com.ranck.study.domain.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 查询所有学生
     *
     * @return
     */
    public List<Student> query();
}
