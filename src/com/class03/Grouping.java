package com.class03;

import org.testng.annotations.Test;

public class Grouping {

    @Test(groups = "smoke")
    public void firstMethod(){
        System.out.println("I am first method");
    }

    @Test(groups = "regression")
    public void secongMethod(){
        System.out.println("I am second method");
    }

    @Test(groups = "smoke")
    public void thirdMethod(){
        System.out.println("I am third method");
    }

    @Test(groups = "smoke")
    public void fourthMethod(){
        System.out.println("I am fourth method");
    }
}
