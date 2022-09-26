package ua.ithillel.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IgnoreTest {

    @Test(enabled = false)
    public void testA(){
        System.out.println("A");

    }

    @Test()
    public void testB(){
        System.out.println("B");
    }
}
