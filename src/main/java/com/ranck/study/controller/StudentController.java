package com.ranck.study.controller;

import com.ranck.study.Student;
import com.ranck.study.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping("/students")
    public List<Student> student () {
        return repository.findAll();
    }

    // path 的id应该必须传吧
    @GetMapping("/student/{id}")
    public Student student (@PathVariable("id") Integer id){
        return repository.findById(id).orElse(new Student());
    }

    @GetMapping("/student/query")
    public String student (@RequestParam(value = "name", required = false, defaultValue = "ranck lee") String name) {
        return "name:" + name;
    }

    @PostMapping("/student")
//    public String sstudent(@RequestBody String student){
//        // 这种是标准的post传参
//        System.out.println(student);
//        return "student: " + student;
//    }

    public Student student(@RequestParam String name, @RequestParam Integer age){
        // 这种也能使用query那个中方式接收
        System.out.println(name);
        System.out.println(age);
        Student s = new Student();
        s.setAge(age);
        s.setName(name);
        return repository.save(s);
    }

    @PutMapping("/student/{id}")
    public Student student (@PathVariable("id") Integer id,
                            @RequestBody String name
                            ){
        Optional<Student> optional = repository.findById(id);
        System.out.println(name);
        if (optional.isPresent()){
            System.out.println(name);

            Student s = optional.get();
            s.setName(name);
//            s.setAge(age);
            return repository.save(s);
        }
        return null;
    }
}
