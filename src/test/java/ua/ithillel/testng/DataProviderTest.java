package ua.ithillel.testng;

import org.testng.annotations.Test;

public class DataProviderTest {
    @Test()
    public void test(String name) {
        System.out.println("Param" + name);
    }
}
