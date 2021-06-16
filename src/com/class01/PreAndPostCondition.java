package com.class01;

import org.testng.annotations.*;

public class PreAndPostCondition {

    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }

    @BeforeTest
    public void beforeTestMethod(){
        System.out.println("I am before method");
    }

    @AfterTest
    public void afterTestMethod(){
        System.out.println("I am after method");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method which will execute before every test");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am before method which will execute after every test");
    }

    @Test
    public void firstFunction(){
        System.out.println("I am aaa test");
    }

    @Test
    public void secondFunction(){
        System.out.println("I am bbb test");
    }
}
