package com.ranck.study.service;

import com.ranck.study.domain.User;
import com.ranck.study.enums.ResultEnum;
import com.ranck.study.exception.UserException;
import com.ranck.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void getAge(Integer id) {
        User user = userRepository.findAllById(id);
        Integer age = user.getAge();
        // 条件不满足做提示 || 如果满足则做一些列操作
        if (age < 7) {
            throw new UserException(ResultEnum.PRESCHOOL);
        } else if (age > 7 && age < 18) {
            throw new UserException(ResultEnum.SCHOOL_STUDENT);
        } else {

        }
    }
}
