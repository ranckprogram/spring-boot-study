package com.ranck.study.dao;

import com.ranck.study.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentDAOImplTest {
    @Test
    public void testQuery () {

        StudentDao studentDao = new StudentDAOImpl();
        List<Student> students = studentDao.query();

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
