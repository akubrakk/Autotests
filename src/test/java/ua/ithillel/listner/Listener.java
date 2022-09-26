package ua.ithillel.listner;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter {
        @Override
        public void onTestSuccess(ITestResult tr) {
                super.onTestSuccess(tr);
                System.out.println("custom listener");
        }
}
