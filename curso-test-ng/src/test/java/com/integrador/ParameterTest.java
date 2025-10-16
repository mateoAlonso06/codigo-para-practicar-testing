package com.integrador;

import static org.testng.Assert.*;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    @Test
    @Parameters({"param1", "param2"})
    public void testWithParameters(@Optional String param1, @Optional String param2) {
        System.out.println("Parameter 1: " + param1);
        System.out.println("Parameter 2: " + param2);

        assertNotEquals(param1, param2);
    }
}
