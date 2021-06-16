package com.class01;

import org.testng.annotations.*;

public class Task1 {

    @BeforeClass
    public void beforeClass(){
        System.out.println("This is before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("This is after class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("This is after method");
    }

    @Test
    public void firstMethod(){
        System.out.println("This is first method");
    }

    @Test
    public void secondMethod(){
        System.out.println("This is second method");
    }
}
