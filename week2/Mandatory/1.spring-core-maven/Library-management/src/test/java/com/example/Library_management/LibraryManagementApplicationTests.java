package com.example.Library_management;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class LibraryManagementApplicationTests {

    @Test
    public void testContextLoads() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        assertNotNull(context);
        context.close();
    }
}