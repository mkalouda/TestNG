package com.class04;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Starting test with the name: "+ iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test pass, we take screenshots");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test fail, I will report it");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Finishing test case with the name: "+ iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
