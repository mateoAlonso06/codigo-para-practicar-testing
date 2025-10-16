package com.integrador;

import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParallelTest {
    @Test
    public void testMethod1() {
        try {
            Thread.sleep(2000);
            LocalDateTime horaActual = LocalDateTime.now();
            String horaFormateada = horaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            System.out.println("Test method 1 Thread " + horaFormateada);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void testMethod2() {
        try {
            Thread.sleep(2000);
            LocalDateTime horaActual = LocalDateTime.now();
            String horaFormateada = horaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            System.out.println("Test method 2 Thread " + horaFormateada);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}
