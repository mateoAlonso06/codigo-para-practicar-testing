package com.integrador;

import org.testng.annotations.*;
import static org.testng.Assert.*;


public class CalculadoraTest {
    @Test
    public void testAddition() {
        int a = 5;
        int b = 3;

        int expected = 8;

        int suma = a + b;

        assertEquals(expected, suma);
    }
}
