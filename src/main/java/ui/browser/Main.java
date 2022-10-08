package ui.browser;

import org.openqa.selenium.WebDriver;

public class Main {

    public static void main(String[] args) {
        WebDriverProviderLazy lazy = WebDriverProviderLazy.getInstance();
        WebDriver driver = lazy.getDriver();

        System.out.println(driver);

        WebDriverProviderLazy lazy1 = WebDriverProviderLazy.getInstance();
        WebDriver driver1 = lazy.getDriver();

        System.out.println(driver1);
    }
}
