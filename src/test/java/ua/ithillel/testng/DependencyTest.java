package ua.ithillel.testng;

import org.testng.annotations.Test;

public class DependencyTest {
    @Test
    public void testOne(){

        System.out.println("Test one");

    }

    @Test(dependsOnMethods = {"testOne"}, alwaysRun = true)
    public void testTwo(){

        System.out.println("Test Two");
    }

    @Test
    public void testTree(){

        System.out.println("Test Tree");
    }
}
