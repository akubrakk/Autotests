package ua.ithillel.testng;

import org.testng.annotations.Test;

public class PriorityTests {

    @Test(priority = 1)
    public void testOne(){

        System.out.println("Test one");

    }

    @Test(priority = 2)
    public void testTwo(){

        System.out.println("Test Two");
    }

    @Test(priority = 3)
    public void testTree(){

        System.out.println("Test Tree");
    }
}
