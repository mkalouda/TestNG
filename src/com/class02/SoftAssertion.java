package com.class02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

    @Test
    public void softAssertionValidation(){
        String expectedText = "This is my testing world";
        String actualText = "THIS IS MY TESTING WORLD";

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(expectedText,actualText);
        System.out.println("My code after first assertion");

        soft.assertTrue(false);
        System.out.println("My code after second assertion");

        soft.assertFalse(true);
        System.out.println("My code after third assertion");

        soft.assertAll();
    }
}
