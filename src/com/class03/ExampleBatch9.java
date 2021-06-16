package com.class03;

import org.testng.annotations.Test;

public class ExampleBatch9 {

    @Test(groups = "smoke")
    public void firstFuntion(){
        System.out.println("I am aaa test");
    }

    @Test(groups = "smoke")
    public void secondFuntion(){
        System.out.println("I am bbb test");
    }

    @Test(groups = "regression")
    public void thirdFuntion(){
        System.out.println("I am ccc test");
    }

    @Test(groups = "smoke")
    public void fourthFuntion(){
        System.out.println("I am ddd test");
    }
}
