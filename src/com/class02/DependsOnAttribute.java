package com.class02;

import org.testng.annotations.Test;

public class DependsOnAttribute {

    @Test
    public void launchApplication(){
        System.out.println("This is my login test");
    }

    @Test(dependsOnMethods = "launchApplication") // this is depending on the launchApplication method
    public void enterCredentials(){
        System.out.println("This is my dependent method");
    }
}
