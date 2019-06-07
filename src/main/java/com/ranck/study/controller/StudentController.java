package com.ranck.study.controller;

import com.ranck.study.domain.User;
import com.ranck.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/students")
    public List<User> student() {
        return repository.findAll();
    }

    // path 的id应该必须传吧
    @GetMapping("/student/{id}")
    public User student(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(new User());
    }

    @GetMapping("/student/query")
    public String student(@RequestParam(value = "name", required = false, defaultValue = "ranck lee") String name) {
        return "name:" + name;
    }

    @PostMapping("/student")
//    public String sstudent(@RequestBody String student){
//        // 这种是标准的post传参
//        System.out.println(student);
//        return "student: " + student;
//    }

    // 这种也能使用query那个中方式接收
    // 采用对象接收才是王道

    public User user(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        return repository.save(user);
    }

    @PutMapping("/student/{id}")
    public User student(@PathVariable("id") Integer id,
                        @RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "age", required = false) Integer age
    ) {
        Optional<User> optional = repository.findById(id);
        if (optional.isPresent()) {
            User s = optional.get();
            s.setName(name);
            s.setAge(age);
            return repository.save(s);
        }
        return null;
    }
}
