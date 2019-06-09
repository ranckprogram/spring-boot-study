package com.ranck.study.util;

import com.ranck.study.utils.JDBCUtil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;


public class JDBCUtilTest {

    @Test
    public void testGetConnection() throws Exception {
        Connection collection = JDBCUtil.getConnection();
        Assert.assertNotNull(collection);
    }
}
