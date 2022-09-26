package ua.ithillel.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExceptiotTest {

    @Test(expectedExceptions = ArithmeticException.class)
    public void testArithmeticException(){
        int a=2;
        int b= 0;
        int result = a/b;
    }
}
