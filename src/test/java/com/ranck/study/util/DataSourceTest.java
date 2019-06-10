package com.ranck.study.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class DataSourceTest {
    private ApplicationContext ctx = null;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;

    }


    @Test
    public void testDataSource() {
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }
}
