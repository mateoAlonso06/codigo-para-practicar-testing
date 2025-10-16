package com.integrador;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DataProviderTest {
    @DataProvider(name = "simpleDataProvider")
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {"Alice", 28},
                {"Bob", 34},
                {"Charlie", 22},
                {"Diana", 30},
                {"Ethan", 26}
        };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void testWithDataProvider(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
        assertTrue(age > 18, "Age should be greater than 18");
    }
}
