package com.ranck.study.repository;

import com.ranck.study.domain.User;
import org.apache.catalina.core.ApplicationContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserRepositoryTest {
//    @Autowired
//    private ApplicationContext ctx = null;

    @Autowired
    UserRepository userRepository;

    @Before
    public void init() {
//        ctx = new ClassPathXmlApplicationContext("beans.xml");
    }

    @After
    public void tearDown() {
//        ctx = null;
    }

    @Test
    public void getUserByName() {
        List<User> users = userRepository.findUsersByNameStartingWith("琪");
        System.out.println(users.toString());
        Assert.assertNotNull(users);
    }

    @Test
    public void getUserForMaxId() {
        User user = userRepository.getUserForMaxId();
        System.out.println(user.toString());
        Assert.assertNotNull(user);
    }

    @Test
    public void testGetUserForNameLike() {
        List<User> users = userRepository.getUserForNameLike("琪");
        for (User user : users) {
            System.out.println(user.toString());
        }
        Assert.assertNotNull(users);
    }

    @Test
    public void testGetCount() {
        Integer count = userRepository.getCount();
        System.out.println(count);
    }

}
