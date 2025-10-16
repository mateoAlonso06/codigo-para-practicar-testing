package com.integrador;

import org.testng.annotations.Test;

public class PriorityAndEnableTest {
    @Test(priority = 2)
    public void testLowPriority() {
        System.out.println("testLowPriority");
    }

    @Test(priority = 1)
    public void testHighPriority() {
        System.out.println("testHighPriority");
    }

    @Test(enabled = false)
    public void testNormalPriority() {
        System.out.println("testNormalPriority");
    }

    @Test
    public void testDisabledPriority() {
        System.out.println("testDisabled");
    }
}
