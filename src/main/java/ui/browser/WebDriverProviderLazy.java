package ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProviderLazy {

    private static WebDriverProviderLazy instance;
    private WebDriver driver;

    private WebDriverProviderLazy() {
        driver = new WebDriverFactory().getDriver();
    }

    public static WebDriverProviderLazy getInstance(){
        if(instance == null){
            instance = new WebDriverProviderLazy();
        }
        return instance;
    }
    public WebDriver getDriver(){
        return driver;
    }
}
