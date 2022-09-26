package ua.ithillel.testng;

import org.testng.annotations.Test;

public class GroupsTests {
    @Test(groups = {"SMOKE"})
    public void testA(){
        System.out.println("SMOKE");

    }

    @Test(groups = {"REGRESSION"})
    public void testB(){
        System.out.println("REGRESSION");
    }
}
