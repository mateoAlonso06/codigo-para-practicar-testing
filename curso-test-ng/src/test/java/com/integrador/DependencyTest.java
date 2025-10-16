package com.integrador;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {
    @Test(groups = {"init"})
    public void testInitialize() {
        System.out.println("Initialize test...");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = {"testInitialize"})
    public void testDependentMethod() {
        System.out.println("Ejecutando prueba dependiente de test initialize");
    }

    @Test(groups = {"setup"})
    public void testSetup() {
        System.out.println("Setup initalize test...");
        Assert.assertTrue(true);
    }

    @Test(dependsOnGroups = {"init", "setup"})
    public void testDependsOnGroup() {
        System.out.println("Ejecutando prueba dependiente de test dependsOnGroup, init y setup");
    }
}
