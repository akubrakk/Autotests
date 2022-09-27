package ui.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui.utils.ConfigProvider;


public class WebDriverFactory {

    private static final String BROWSER = System.getProperty("browser", ConfigProvider.BROWSER);

    private static WebDriver driver;



    public static WebDriver getDriver(){
        driver = getDriver(Browser.valueOf(ConfigProvider.BROWSER.toUpperCase()));
      return driver;
    }


    private static WebDriver getDriver(Browser browser){
        switch (browser){
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            default:
                throw new IllegalArgumentException("Wrong browser type provided. Choices are: chrome, firefox");
        }
    }

    private static WebDriver getFirefoxDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
    private static WebDriver getChromeDriver() {
        if(driver== null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
}
