package ua.ithillel.testng;

import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTest {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("BeforeGroups");
    }

    @AfterGroups
    public void afterGroups(){
        System.out.println("AfterGroups");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod");
    }

    @Test
    public void testOne(){
        Assert.assertTrue(true);
        System.out.println("Test one");

    }

    @Test
    public void testTwo(){
        Assert.assertTrue(true);
        System.out.println("Test Two");
    }
}
