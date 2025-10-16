package com.integrador;


import org.testng.annotations.*;

import static org.testng.Assert.*;


public class BasicCalculatorTest {
    private int calculatorValue;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Iniciando suite de pruebas...");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Iniciando clase de pruebas...");
    }

    @BeforeMethod
    public void beforeMethod() {
        calculatorValue = 0;
        System.out.println("Iniciando method de pruebas...");
    }

    @Test
    public void testAddition() {
        calculatorValue += 5;
        calculatorValue += 5;

        assert calculatorValue == 10;
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Finalizando metodo de pruebas...");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Finalizando clase de pruebas...");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Finalizando suite de pruebas...");
    }
}
