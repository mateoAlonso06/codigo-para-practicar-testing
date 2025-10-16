package com.integrador;

import org.testng.annotations.Test;

public class GroupTest {
    @Test(groups = {"smoke"})
    public void testSmoke1() {
        System.out.println("smoke test...");
    }

    @Test(groups = {"smoke", "regression"})
    public void testSmokeAndRegression() {
        System.out.println("Smoke test and regression...");
    }

    @Test(groups = {"regression"})
    public void testRegression() {
        System.out.println("testRegression");
    }

    @Test(groups = {"sanity"})
    public void testSanity() {
        System.out.println("sanity test...");
    }
}
